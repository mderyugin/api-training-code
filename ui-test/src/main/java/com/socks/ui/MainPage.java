package com.socks.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public static MainPage open() {
        Selenide.open("https://dev-cinescope.store");
        return new MainPage();
    }

    public void loginAs(String email, String password) {
        $("#login > a").click();
        $("#username-modal").setValue(email);
        $("#password-modal").setValue(password);
        $("#login-modal p button").click();
    }
}
