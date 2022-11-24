package com.company.exchange.core.group;

import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;

@AccessGroup(name = "Company")
public class RootGroup extends AnnotatedAccessGroupDefinition {
}