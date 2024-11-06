package com.socks.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public static MainPage open() {
        Selenide.open("https://dev-cinescope.store");
        return new MainPage();
    }

    public void loginAs(String email, String password) {
        $("a[href='/login']").click();
        Selenide.sleep(2000);
        $("input#email").setValue(email);
        $("input#password").setValue(password);
        Selenide.sleep(2000);
        $("button[type='submit']").click();
    }
}
