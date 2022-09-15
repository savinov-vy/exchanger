package com.company.exchange.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = AnonymousRole.NAME)
public class AnonymousRole extends AnnotatedRoleDefinition {
    public final static String NAME = "AnonymousRole";

    @ScreenAccess(screenIds = {"exchange_RegisterScreen", "login-ext", "login", "loginWindow"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}