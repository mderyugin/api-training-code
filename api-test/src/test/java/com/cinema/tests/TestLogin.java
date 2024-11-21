package com.cinema.tests;


import com.github.javafaker.Faker;
import com.cinema.api.conditions.Conditions;
import com.cinema.api.payloads.LoginUserPayload;
import com.cinema.api.services.UserApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class TestLogin {

    private final UserApiService userApiService = new UserApiService();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://dev-cinescope.store";
    }

    @Test
    public void testCanLoginUser() {
        LoginUserPayload user = (LoginUserPayload) new LoginUserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.loginUser(user)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", not(isEmptyOrNullString())));
    }
}
