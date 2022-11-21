package com.company.exchange.core.role;

import com.company.exchange.constant.AppConstants;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = AnonymousRole.NAME)
public class AnonymousRole extends AnnotatedRoleDefinition {
    public final static String NAME = AppConstants.ANONYMOUS_ROLE;

    @ScreenAccess(screenIds = {"exchange_RegisterScreen", "login-ext", "login", "loginWindow"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}