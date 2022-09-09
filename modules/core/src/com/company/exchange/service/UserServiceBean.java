package com.company.exchange.service;

import com.company.exchange.entity.AppUser;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.global.ViewBuilder;
import org.springframework.stereotype.Service;

@Service(UserService.NAME)
public class UserServiceBean implements UserService {
    private final Persistence persistence;

    public UserServiceBean(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public AppUser findByLogin(String login) {
        AppUser user;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            user = (AppUser) em.createQuery("select u from sec$User u where u.login=:login")
                    .setView(ViewBuilder.of(AppUser.class).addView(View.LOCAL).build())
                    .setParameter("login", login)
                    .getFirstResult();
            tx.commit();
        }
        return user;
    }
}