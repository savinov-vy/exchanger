package com.company.exchange.web.screens.register;

import com.company.exchange.service.RegistrationService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.validation.MethodParametersValidationException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.PasswordField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UiController("exchange_RegisterScreen")
@UiDescriptor("register-screen.xml")
public class RegisterScreen extends Screen {
    @Inject
    private TextField<String> loginField;
    @Inject
    private PasswordField passwordField;

    @Inject
    private RegistrationService registrationService;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private PasswordField confirmPasswordField;


    /**
     * "OK" button click handler.
     */
    @Subscribe("okBtn")
    public void onOkBtnClick(Button.ClickEvent event) {
        try {
            registrationService.registerUser(getLogin(), getPassword());

            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("Created user " + getLogin())
                    .show();

            close(WINDOW_COMMIT_AND_CLOSE_ACTION);
        } catch (MethodParametersValidationException e) {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption(
                            messages.getMessage(
                                    "com.company.sample.validation",
                                    "UserExistsValidator.message"))
                    .show();
        }
    }

    @Subscribe("loginField")
    public void onLoginFieldTextChange(TextInputField.TextChangeEvent event) {
        String login = getLogin();
        if (login != null) {
            Pattern validEmailRegex = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = validEmailRegex.matcher(login);
            boolean isLoginValueEmailPattern = matcher.find();
            if (isLoginValueEmailPattern) {
                loginField.setCaption("msg://integerFieldName");
            }
        }
    }

    @Subscribe("loginField")
    public void onLoginFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        System.out.println("!!!");
    }

    /**
     * "Cancel" button click handler.
     */
    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(WINDOW_CLOSE_ACTION);
    }

    public String getLogin() {
        return loginField.getValue();
    }

    /**
     * @return entered password
     */
    public String getPassword() {
        return passwordField.getValue();
    }
}