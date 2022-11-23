package com.company.exchange.core.role;

import com.company.exchange.entity.AppUser;
import com.company.exchange.entity.Disk;
import com.company.exchange.entity.Genre;
import com.company.exchange.entity.TakenItem;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = CustomerRole.NAME)
public class CustomerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "CustomerRole";

    @ScreenAccess(screenIds = {"application-exchange", "exchange_Disk.browse", "mainWindow", "main",
            "exchange_Disk.edit", "exchange_RegisterScreen"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = AppUser.class, operations = {EntityOp.READ, EntityOp.CREATE})
    @EntityAccess(entityClass = Disk.class, operations = {EntityOp.UPDATE, EntityOp.READ})
    @EntityAccess(entityClass = User.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = TakenItem.class, operations = {EntityOp.READ, EntityOp.UPDATE, EntityOp.CREATE})
    @EntityAccess(entityClass = Genre.class, operations = EntityOp.READ)
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = AppUser.class, view = {"firstName", "lastName", "middleName", "name",
            "language", "timeZone", "login", "loginLowerCase"})
    @EntityAttributeAccess(entityClass = User.class, view = {"login", "name", "firstName", "lastName", "middleName"})
    @EntityAttributeAccess(entityClass = TakenItem.class, modify = "user", view = "disk")
    @EntityAttributeAccess(entityClass = Genre.class, view = {"name", "disk"})
    @EntityAttributeAccess(entityClass = Disk.class, modify = "takenItem", view = {"genres", "description", "name"})
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}