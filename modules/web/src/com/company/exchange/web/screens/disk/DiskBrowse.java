package com.company.exchange.web.screens.disk;

import com.company.exchange.constant.AppConstants;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;
import com.haulmont.cuba.security.global.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Collection;

@UiController("exchange_Disk.browse")
@UiDescriptor("disk-browse.xml")
@LookupComponent("disksTable")
@LoadDataBeforeShow
public class DiskBrowse extends StandardLookup<Disk> {
    private static final Logger log = LoggerFactory.getLogger(DiskBrowse.class);
    @Inject
    private UserSession userSession;
    @Inject
    private Button createBtn;
    @Inject
    private Button removeBtn;
    @Inject
    private Button editBtn;
    @Inject
    private MessageBundle messageBundle;
    @Inject
    private CollectionLoader<Disk> disksDl;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        Collection<String> roles = userSession.getRoles();
        if (roles.contains(AppConstants.CUSTOMER_ROLE)) {
            String description = messageBundle.getMessage("btnEditCaption");
            createBtn.setVisible(false);
            removeBtn.setVisible(false);
            editBtn.setCaption(description);
        }
    }

    @Install(to = "disksTable.edit", subject = "afterCommitHandler")
    private void disksTableEditAfterCommitHandler(Disk disk) {
        log.info("Changed data disk with id: " + disk.getUuid());
        disksDl.load();
    }
}