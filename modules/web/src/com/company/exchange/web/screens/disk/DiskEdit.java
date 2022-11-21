package com.company.exchange.web.screens.disk;

import com.company.exchange.entity.TakenItem;
import com.company.exchange.service.TakenItemService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;
import com.company.exchange.constant.AppConstants;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Collection;
import java.util.function.Consumer;

@UiController("exchange_Disk.edit")
@UiDescriptor("disk-edit.xml")
@EditedEntityContainer("diskDc")
@LoadDataBeforeShow
public class DiskEdit extends StandardEditor<Disk> {
    @Inject
    private TakenItemService takenItemService;
    @Inject
    private Dialogs dialogs;
    @Inject
    private Messages messages;
    @Inject
    private DataContext dataContext;
    @Inject
    private UserSession userSession;
    @Inject
    private MessageBundle messageBundle;
    @Inject
    private Button closeBtn;
    @Inject
    private Button commitAndCloseBtn;
    @Inject
    private ButtonsPanel genresButtonsPanel;
    @Inject
    private Button retrieveBtn;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Disk> event) {
        Disk newDisk = event.getEntity();
        TakenItem managerTakenItem = takenItemService.createNewManagerTaken(newDisk);
        TakenItem hasManager = dataContext.merge(managerTakenItem);
        newDisk.setTakenItem(hasManager);
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        Collection<String> roles = userSession.getRoles();
        if (roles.contains(AppConstants.CUSTOMER_ROLE)) {
            String description = messageBundle.getMessage("closeBtnCaption");
            commitAndCloseBtn.setVisible(false);
            genresButtonsPanel.setVisible(false);
            closeBtn.setCaption(description);
        } else if (roles.contains(AppConstants.MANAGER_ROLE)) {
            retrieveBtn.setVisible(false);
        }
    }

    @Subscribe("takeBtn")
    public void onTakeBtnClick(Button.ClickEvent event) {
        Consumer<Disk> userTakeDisk = (disk) -> takenItemService.take(disk);
        String takeDiskDialog = messages.getMainMessage(AppConstants.TAKE_DISK_DIALOG);
        showDialogExchangeDisk(userTakeDisk, takeDiskDialog);
    }

    @Subscribe("retrieveBtn")
    public void onRetrieveBtnClick(Button.ClickEvent event) {
        Consumer<Disk> retrieveDiskToManager = (disk) -> takenItemService.retrieve(disk);
        String retrieveDiskDialog = messages.getMainMessage(AppConstants.RETRIEVE_DISK_DIALOG);
        showDialogExchangeDisk(retrieveDiskToManager, retrieveDiskDialog);
    }

    private void showDialogExchangeDisk(Consumer<Disk> exchange, String message) {
        Disk editedDisk = getEditedEntity();
        String nameDisk = editedDisk.getName();
        String formatMessage = String.format(message, nameDisk);
        dialogs.createOptionDialog(Dialogs.MessageType.WARNING)
                .withCaption(messages.getMainMessage(AppConstants.WARNING_CAPTION))
                .withMessage(formatMessage)
                .withActions(
                        new DialogAction(DialogAction.Type.YES).withHandler(e -> {
                                    exchange.accept(editedDisk);
                                    close(StandardOutcome.COMMIT);
                                }
                        ),
                        new DialogAction(DialogAction.Type.CANCEL))
                .show();
    }
}