package com.company.exchange.web.screens.disk;

import com.company.exchange.entity.TakenItem;
import com.company.exchange.service.TakenItemService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;

import javax.inject.Inject;

import static java.util.Objects.nonNull;

@UiController("exchange_Disk.browse")
@UiDescriptor("disk-browse.xml")
@LookupComponent("disksTable")
@LoadDataBeforeShow
public class DiskBrowse extends StandardLookup<Disk> {
    @Inject
    private GroupTable<Disk> disksTable;
    @Inject
    private TakenItemService takenItemService;

    @Subscribe("takeBtn")
    public void onTakeBtnClick(Button.ClickEvent event) {
        Disk selected = disksTable.getSingleSelected();
        if (nonNull(selected)) {
            TakenItem hasCurrentUser = takenItemService.setCurrentUserTaken(selected);
            selected.setTakenItem(hasCurrentUser);
        } else {
            showWarningEmptySelected();
        }
    }

    private void showWarningEmptySelected() {
        System.out.println("!!!");
    }
}