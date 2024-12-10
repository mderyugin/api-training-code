package com.cinema.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public static MainPage open() {
        Selenide.open("https://dev-cinescope.store");
        return new MainPage();
    }
    public LoginPage goToLoginPage() {
        $("a[href='/login']").click();
        return new LoginPage();
    }
}
