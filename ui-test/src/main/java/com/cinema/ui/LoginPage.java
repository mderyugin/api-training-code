package com.cinema.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailInput =  $("input#email");
    private final SelenideElement passwordInput = $("input#password");
    private final SelenideElement submitButton = $("button[type='submit']");

    public LoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }
    public void submitButton() {
        submitButton.click();
    }
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        submitButton();
    }
}

