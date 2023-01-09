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
import com.haulmont.reports.entity.Report;

@Role(name = ManagerRole.NAME)
public class ManagerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "ManagerRole";

    @ScreenAccess(screenIds = {"exchange_AppUser.browse", "application-exchange", "exchange_Disk.browse", "exchange_Genre.browse", "mainWindow", "exchange_AppUser.edit", "exchange_Disk.edit", "exchange_Genre.edit", "report$Report.run", "reports", "report$inputParameters"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = Report.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = TakenItem.class, operations = {EntityOp.READ, EntityOp.UPDATE, EntityOp.CREATE})
    @EntityAccess(entityClass = User.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Disk.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @EntityAccess(entityClass = Genre.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @EntityAccess(entityClass = AppUser.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = Report.class, modify = "*")
    @EntityAttributeAccess(entityClass = User.class, view = {"login", "name", "firstName", "lastName", "middleName"})
    @EntityAttributeAccess(entityClass = TakenItem.class, modify = {"user", "disk"})
    @EntityAttributeAccess(entityClass = Disk.class, modify = {"genres", "description", "name"}, view = "takenItem")
    @EntityAttributeAccess(entityClass = Genre.class, modify = {"name", "disk"})
    @EntityAttributeAccess(entityClass = AppUser.class, modify = "active", view = {"login", "name", "firstName",
            "lastName", "middleName", "loginLowerCase", "email", "timeZone"})
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}