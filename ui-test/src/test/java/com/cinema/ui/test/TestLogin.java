package com.cinema.ui.test;

import com.cinema.ui.LoginPage;
import com.pages.api.conditions.Conditions;
import com.cinema.ui.MainPage;
import com.pages.api.payloads.LoginUserPayload;
import com.pages.api.services.UserApiService;
//import com.socks.ui.LoggedUserPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class TestLogin extends BaseUiTest {

    private final Faker faker = new Faker();
    private final UserApiService userApiService = new UserApiService();
    
    @Test
    public void userCanLoginWithValidCredentials() {

//        String randomEmail = faker.internet().emailAddress();
//        String randomPassword = faker.internet().password();

        MainPage mainPage = MainPage.open();
        LoginPage loginPage = mainPage.goToLoginPage();

        loginPage.login("test-admin@mail.com", "KcLMmxkJMjBD1");
    }

}
