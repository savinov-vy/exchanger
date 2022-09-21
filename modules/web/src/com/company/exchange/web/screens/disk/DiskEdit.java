package com.company.exchange.web.screens.disk;

import com.company.exchange.entity.TakenItem;
import com.company.exchange.service.TakenItemService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;

import javax.inject.Inject;

@UiController("exchange_Disk.edit")
@UiDescriptor("disk-edit.xml")
@EditedEntityContainer("diskDc")
@LoadDataBeforeShow
public class DiskEdit extends StandardEditor<Disk> {
    @Inject
    private TakenItemService takenItemService;
    @Inject
    private DataContext dataContext;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Disk> event) {
        Disk newDisk = event.getEntity();
        setOwnerDiskManager(newDisk);
    }

    @Subscribe("takeBtn")
    public void onTakeBtnClick(Button.ClickEvent event) {
        Disk takeDisk = getEditedEntity();
        setOwnerDiskCustomer(takeDisk);
    }

    @Subscribe("DiskEditCommitAndCloseBtn")
    public void onDiskEditCommitAndCloseBtnClick(Button.ClickEvent event) {
        Disk editedDisk = getEditedEntity();
        takenItemService.setDeleteBeforeTakenItem(editedDisk);
    }

    @Subscribe("giveBtn")
    public void onGiveBtnClick(Button.ClickEvent event) {
        Disk giveDisk = getEditedEntity();
        setOwnerDiskManager(giveDisk);
    }

    private void setOwnerDiskCustomer(Disk disk) {
        TakenItem managerTakenItem = takenItemService.setCurrentUserTaken(disk);
        TakenItem hasManager = dataContext.merge(managerTakenItem);
        disk.setTakenItem(hasManager);
    }

    private void setOwnerDiskManager(Disk disk) {
        TakenItem takenItem = takenItemService.setManagerTaken(disk);
        TakenItem hasManager = dataContext.merge(takenItem);
        disk.setTakenItem(hasManager);
    }
}