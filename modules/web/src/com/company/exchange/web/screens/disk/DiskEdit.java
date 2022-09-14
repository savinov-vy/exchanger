package com.company.exchange.web.screens.disk;

import com.company.exchange.entity.TakenItem;
import com.company.exchange.entity.TakenItemService;
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
        TakenItem managerTakenItem = takenItemService.createNewManagerTaken(newDisk);
        TakenItem hasManager = dataContext.merge(managerTakenItem);
        newDisk.setTakenItem(hasManager);
    }
}