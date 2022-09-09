package com.company.exchange.service;

import com.company.exchange.entity.AppUser;

public interface UserService {
    String NAME = "exchange_UserService";

    AppUser findByLogin(String login);
}