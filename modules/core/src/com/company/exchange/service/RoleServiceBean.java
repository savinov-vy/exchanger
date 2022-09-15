package com.company.exchange.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.security.entity.Role;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(RoleService.NAME)
public class RoleServiceBean implements RoleService {
    @Inject
    private DataManager dataManager;

    @Override
    public Role getRoleByName(String name) {
        return dataManager.load(Role.class)
                .query("select r from sec$Role r where r.name = :roleName")
                .parameter("roleName", name)
                .view(View.LOCAL)
                .one();
    }
}