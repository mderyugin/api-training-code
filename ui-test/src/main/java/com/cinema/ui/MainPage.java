package com.cinema.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public static MainPage open() {
        Selenide.open("https://dev-cinescope.store");
        return new MainPage();
    }

    public void loginAs(String email, String password) {
        $("a[href='/login']").click();
        $("input#email").setValue(email);
        $("input#password").setValue(password);
        $("button[type='submit']").click();
        Selenide.sleep(2000);
    }
}
