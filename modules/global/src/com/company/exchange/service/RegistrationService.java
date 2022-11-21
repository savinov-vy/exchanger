package com.company.exchange.service;

import com.company.exchange.entity.AppUser;

public interface RegistrationService {
    String NAME = "exchange_RegistrationService";

    boolean save(AppUser newUser);
}