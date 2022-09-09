package com.company.exchange.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.Entity;

@Entity(name = "exchange_AppUser")
@Extends(User.class)
@NamePattern("%s %s|login,name")
public class AppUser extends User {
    private static final long serialVersionUID = 3548010996494422520L;
}