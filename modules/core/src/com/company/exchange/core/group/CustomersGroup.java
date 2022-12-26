package com.company.exchange.core.group;

import com.company.exchange.constant.AppConstants;
import com.company.exchange.entity.AppUser;
import com.company.exchange.entity.Disk;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;
import com.haulmont.cuba.security.app.group.annotation.Constraint;
import com.haulmont.cuba.security.entity.EntityOp;

@AccessGroup(name = AppConstants.CUSTOMER_GROUP, parent = RootGroup.class)
public class CustomersGroup extends AnnotatedAccessGroupDefinition {
    private final UserSessionSource session;

    public CustomersGroup(UserSessionSource session) {
        this.session = session;
    }

    @Constraint(operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    public boolean diskConstraints(Disk disk) {
        AppUser ownerDisk = disk.getTakenItem().getUser();
        boolean diskHasManager = ownerDisk.getGroupNames().equals("ManagerGroup");
        String currentUserLogin = session.getUserSession().getUser().getLogin();
        boolean diskHasCurrentUser = ownerDisk.getLogin().equals(currentUserLogin);
        return diskHasManager || diskHasCurrentUser;
    }
}