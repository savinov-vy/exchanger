package com.company.exchange.service;

import com.company.exchange.entity.AppUser;

import java.util.List;

public interface UserService {
    String NAME = "exchange_UserService";

    AppUser findByLogin(String login);

    AppUser getOneManager();

    List<AppUser> getUsersByRoleName(String roleName);

    AppUser currentUser();
}