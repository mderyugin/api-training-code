package com.cinema.ui.test;

import com.cinema.api.conditions.Conditions;
import com.cinema.ui.MainPage;
import com.codeborne.selenide.Selenide;
import com.cinema.api.payloads.LoginUserPayload;
import com.cinema.api.services.UserApiService;
//import com.socks.ui.LoggedUserPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestLogin extends BaseUiTest {

    private final UserApiService userApiService = new UserApiService();

    private MainPage mainPage;
    
    @Test
    public void userCanLoginWithValidCredentials() {
        open("https://dev-cinescope.store/");
        //given
        LoginUserPayload loginUserPayload = (LoginUserPayload) new LoginUserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.loginUser(loginUserPayload)
                .shouldHave(Conditions.statusCode(200));

        // when
        MainPage.open()
                .loginAs(loginUserPayload.email(), loginUserPayload.password());
        Selenide.sleep(2000);

//        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
//        loggedUserPage.logoutBtn().shouldHave(text("Выйти"));

    }

}
