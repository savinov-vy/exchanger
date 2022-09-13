package com.company.exchange.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = CustomerRole.NAME)
public class CustomerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "CustomerRole";
}