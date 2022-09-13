package com.company.exchange.entity;

public interface TakenItemService {
    String NAME = "exchange_TakenItemService";

    TakenItem createNewManagerTaken(Disk disk);
}