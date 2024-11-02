package com.socks.ui.test;

import com.codeborne.selenide.Selenide;
import com.socks.api.conditions.Condition;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.socks.api.conditions.Conditions.*;

public class TestLogin extends BaseUiTest {

    private final UserApiService userApiService = new UserApiService();

    private MainPage mainPage;
    
    @Test
    public void userCanLoginWithValidCredentials() {
        open("https://dev-cinescope.store/");
        //given
        UserPayload userPayload = (UserPayload) new UserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.registerUser(userPayload)
                .shouldHave(statusCode(403));

        // when
        MainPage.open()
                .loginAs(userPayload.email(), userPayload.password());
        Selenide.sleep(2000);

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
        loggedUserPage.logoutBtn().shouldHave(text("Выйти"));

    }

}
