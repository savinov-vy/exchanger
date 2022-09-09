package com.company.exchange.web.screens.register;

import com.company.exchange.entity.AppUser;
import com.company.exchange.service.RegistrationService;
import com.company.exchange.service.UserService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GridLayout;
import com.haulmont.cuba.gui.components.PasswordField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationErrors;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.screen.MessageBundle;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.ScreenValidation;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static com.haulmont.cuba.gui.Notifications.NotificationType.ERROR;
import static com.haulmont.cuba.gui.Notifications.NotificationType.HUMANIZED;
import static java.util.Objects.isNull;

@UiController("exchange_RegisterScreen")
@UiDescriptor("register-screen.xml")
public class RegisterScreen extends Screen {

    private static final Logger log = LoggerFactory.getLogger(RegisterScreen.class);

    @Inject
    private TextField<String> loginField;
    @Inject
    private PasswordField passwordField;
    @Inject
    private PasswordField confirmPasswordField;
    @Inject
    private RegistrationService registrationService;
    @Inject
    private ScreenValidation screenValidation;
    @Inject
    private GridLayout gridRegister;
    @Inject
    private Notifications notifications;
    @Inject
    private MessageBundle messageBundle;
    @Inject
    private UserService userService;

    @Subscribe
    public void onInit(InitEvent event) {
        loginField.addValidator(this::loginExistValidator);
        confirmPasswordField.addValidator(this::passwordEqualsConfirmPasswordValidator);
    }

    @Subscribe("okBtn")
    public void onOkBtnClick(Button.ClickEvent event) {
        if (isValidFillRegisterForm()) {
            registrationUser();
        }
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(WINDOW_CLOSE_ACTION);
    }

    private boolean isValidFillRegisterForm() {
        ValidationErrors errors = screenValidation.validateUiComponents(gridRegister);
        if (!errors.isEmpty()) {
            log.warn("ValidationErrors not empty: {}", errors);
            screenValidation.showValidationErrors(this, errors);
            return false;
        }
        return true;
    }

    private void registrationUser() {
        String login = getLogin();
        boolean savedSuccess = registrationService.registerUser(login, getPassword());
        if (savedSuccess) {
            log.info("Created new user {}", login);
            showNotification(HUMANIZED, "register.createdNewUser.description", login);
            close(WINDOW_COMMIT_AND_CLOSE_ACTION);
        } else {
            showNotification(ERROR, "register.userNotSave.description", login);
        }
    }

    private void showNotification(Notifications.NotificationType humanized, String descriptionKey, String param) {
        notifications.create(humanized)
                .withCaption(messageBundle.formatMessage("register.notification.caption"))
                .withDescription(messageBundle.formatMessage(descriptionKey, param))
                .show();
    }

    private void loginExistValidator(String login) {
        AppUser existUser = userService.findByLogin(login);
        if (!isNull(existUser)) {
            throw new ValidationException(messageBundle.formatMessage("error.login.userExist", login));
        }
    }

    private void passwordEqualsConfirmPasswordValidator(String confirmPassword) {
        String password = passwordField.getValue();
        if (password != null && !password.equals(confirmPassword)) {
            throw new ValidationException(messageBundle.formatMessage("error.password.confirmPassword"));
        }
    }

    public String getLogin() {
        return loginField.getValue();
    }

    public String getPassword() {
        return passwordField.getValue();
    }
}