package com.company.exchange.service;

public interface RegistrationService {
    String NAME = "exchange_RegistrationService";

    boolean registerUser(String login, String password);
}