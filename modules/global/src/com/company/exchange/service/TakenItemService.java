package com.company.exchange.service;

import com.company.exchange.entity.Disk;
import com.company.exchange.entity.TakenItem;

public interface TakenItemService {
    String NAME = "exchange_TakenItemService";

    void retrieve(Disk disk);

    void take(Disk disk);

    TakenItem createNewManagerTaken(Disk disk);
}