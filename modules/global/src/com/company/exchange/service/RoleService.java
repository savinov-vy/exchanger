package com.company.exchange.service;

import com.haulmont.cuba.security.entity.Role;

public interface RoleService {
    String NAME = "exchange_RoleService";

    Role getRoleByName(String roleName);
}