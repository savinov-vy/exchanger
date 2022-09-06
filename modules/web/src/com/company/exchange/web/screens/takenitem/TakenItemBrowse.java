package com.company.exchange.web.screens.takenitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.TakenItem;

@UiController("exchange_TakenItem.browse")
@UiDescriptor("taken-item-browse.xml")
@LookupComponent("takenItemsTable")
@LoadDataBeforeShow
public class TakenItemBrowse extends StandardLookup<TakenItem> {
}