package com.company.exchange.service;

import com.company.exchange.entity.Disk;
import com.company.exchange.entity.TakenItem;

public interface TakenItemService {
    String NAME = "exchange_TakenItemService";

    TakenItem setManagerTaken(Disk disk);

    TakenItem setCurrentUserTaken(Disk disk);

    void setDeleteBeforeTakenItem(Disk disk);
}