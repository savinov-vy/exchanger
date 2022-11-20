package com.company.exchange.service;

import com.company.exchange.constant.AppConstants;
import com.company.exchange.core.role.ManagerRole;
import com.company.exchange.entity.AppUser;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PasswordEncryption;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.global.ViewBuilder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(UserService.NAME)
public class UserServiceBean implements UserService {
    private final Persistence persistence;

    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;
    @Inject
    private PasswordEncryption passwordEncryption;
    @Inject
    private UserSessionSource userSessionSource;

    public UserServiceBean(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public AppUser findByLogin(String login) {
        AppUser user;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            user = em.createQuery("select u from sec$User u where u.login=:login", AppUser.class)
                    .setView(ViewBuilder.of(AppUser.class).addView(View.LOCAL).build())
                    .setParameter("login", login)
                    .getFirstResult();
            tx.commit();
        }
        return user;
    }

    @Override
    public AppUser getOneManager() {
        List<AppUser> managers = getUsersByRoleName(ManagerRole.NAME);
        return managers.stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<AppUser> getUsersByRoleName(String roleName) {
        return dataManager.load(AppUser.class)
                .query("select ur.user from sec$UserRole ur " +
                        "where ur.roleName=?1", roleName)
                .view(ViewBuilder.of(AppUser.class).addView(View.MINIMAL).build())
                .list();
    }

    @Override
    public AppUser createUserOf(String login, String password) {
        AppUser user = metadata.create(AppUser.class);
        user.setLogin(login);
        user.setPassword(passwordEncryption.getPasswordHash(user.getId(), password));
        user.setGroupNames(AppConstants.DEFAULT_GROUP);
        return user;
    }

    @Override
    public AppUser currentUser() {
        return (AppUser) userSessionSource.getUserSession().getUser();
    }
}