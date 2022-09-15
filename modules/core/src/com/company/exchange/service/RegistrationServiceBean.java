package com.company.exchange.service;

import com.company.exchange.core.role.CustomerRole;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PasswordEncryption;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static com.company.exchange.constant.AppConstants.IS_SUCCESSFULLY_SAVE;

@Service(RegistrationService.NAME)
public class RegistrationServiceBean implements RegistrationService {

    private static final Logger log = LoggerFactory.getLogger(RegistrationServiceBean.class);

    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;
    @Inject
    private PasswordEncryption passwordEncryption;
    @Inject
    private RoleService roleService;

    @Override
    public boolean registerUser(String login, String password) {
        Role customerRole = roleService.getRoleByName(CustomerRole.NAME);
        User user = metadata.create(User.class);
        user.setLogin(login);
        user.setPassword(passwordEncryption.getPasswordHash(user.getId(), password));

        UserRole userRole = metadata.create(UserRole.class);
        userRole.setUser(user);
        userRole.setRole(customerRole);

        try {
            dataManager.commit(new CommitContext(user, userRole));
        } catch (Exception e) {
            log.warn("Created new user not successfully. Exception with message: " + e.getMessage());
            return !IS_SUCCESSFULLY_SAVE;
        }
        return IS_SUCCESSFULLY_SAVE;
    }
}