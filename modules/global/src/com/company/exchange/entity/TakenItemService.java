package com.company.exchange.entity;

public interface TakenItemService {
    String NAME = "exchange_TakenItemService";

    TakenItem setManagerTaken(Disk disk);

    TakenItem setCurrentUserTaken(Disk disk);
}