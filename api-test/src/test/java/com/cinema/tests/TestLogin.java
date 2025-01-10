package com.cinema.tests;


import com.pages.api.IProjectConfig;
import com.github.javafaker.Faker;
import com.pages.api.assertions.AssertableResponse;
import com.pages.api.conditions.Conditions;
import com.pages.api.payloads.LoginUserPayload;
import com.pages.api.responses.LoginResponse;
import com.pages.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestLogin {

    private final Faker faker = new Faker();
    private final UserApiService userApiService = new UserApiService();

    @BeforeAll
    public static void setUp() {
        {
            IProjectConfig config = ConfigFactory.create(IProjectConfig.class);
            RestAssured.baseURI = config.baseUri();
        }
    }

    @ParameterizedTest
    @CsvSource({
            "test-admin@mail.com, KcLMmxkJMjBD1, true",
            "invalid-email@mail.com, KcLMmxkJMjBD1, false",
            "test-admin@mail.com, wrongPassword, false",
            "invalid-email@mail.com, wrongPassword, false"
    })
    public void testLoginUser(String email, String password, boolean isSuccess) {
        LoginUserPayload loginUser = new LoginUserPayload()
                .email(email)
                .password(password);

        AssertableResponse response = userApiService.loginUser(loginUser);

        if (isSuccess) {
            LoginResponse loginResponse = response
                    .shouldHave(Conditions.statusCode(200))
                    .asPojo(LoginResponse.class);

            assertThat(loginResponse.getAccessToken())
                    .as("Access token должен быть не пустым")
                    .isNotNull()
                    .isNotEmpty();
        } else {
            response.shouldHave(Conditions.statusCode(401));
        }
    }

}
