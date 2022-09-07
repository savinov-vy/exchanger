package com.company.exchange.service;

import com.haulmont.cuba.security.entity.User;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.UUID;

public interface RegistrationService {
    String NAME = "exchange_RegistrationService";
    @Validated
    RegistrationResult registerUser(String login, String password);

    class RegistrationResult implements Serializable {

        private UUID userId;

        public RegistrationResult(User user) {
            if (user != null) {
                this.userId = user.getId();
            }
        }

        public UUID getUserId() {
            return userId;
        }
    }
}