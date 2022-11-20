package com.company.exchange.web.screens.disk;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Disk;

@UiController("exchange_Disk.browse")
@UiDescriptor("disk-browse.xml")
@LookupComponent("disksTable")
@LoadDataBeforeShow
public class DiskBrowse extends StandardLookup<Disk> {
}