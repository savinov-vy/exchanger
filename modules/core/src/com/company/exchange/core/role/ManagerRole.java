package com.company.exchange.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = ManagerRole.NAME)
public class ManagerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "ManagerRole";
}