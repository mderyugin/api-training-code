package com.socks.tests;


import com.github.javafaker.Faker;
import com.socks.api.conditions.Conditions;
import com.socks.api.conditions.StatusCodeCondition;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker();



    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://dev-cinescope.store";
    }

    @Test
    public void testCanRegisterNewUser() {
        UserPayload user = (UserPayload) new UserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("id", not(isEmptyOrNullString())));
    }

}
