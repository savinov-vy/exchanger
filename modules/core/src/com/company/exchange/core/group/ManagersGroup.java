package com.company.exchange.core.group;

import com.company.exchange.constant.AppConstants;
import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;

@AccessGroup(name = AppConstants.MANAGER_GROUP, parent = RootGroup.class)
public class ManagersGroup extends AnnotatedAccessGroupDefinition {
}