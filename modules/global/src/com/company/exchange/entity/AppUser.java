package com.company.exchange.entity;

import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.Entity;

@Entity(name = "exchange_AppUser")
@Extends(User.class)
public class AppUser extends User {
    private static final long serialVersionUID = 3548010996494422520L;
}