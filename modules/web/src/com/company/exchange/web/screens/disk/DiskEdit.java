package com.company.exchange.web.screens.disk;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;

@UiController("exchange_Disk.edit")
@UiDescriptor("disk-edit.xml")
@EditedEntityContainer("diskDc")
@LoadDataBeforeShow
public class DiskEdit extends StandardEditor<Disk> {
}