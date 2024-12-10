package com.cinema.tests;


import com.pages.api.IProjectConfig;
import com.github.javafaker.Faker;
import com.pages.api.conditions.Conditions;
import com.pages.api.payloads.LoginUserPayload;
import com.pages.api.responses.LoginResponse;
import com.pages.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testCanLoginUser() {
//       String randomEmail = faker.internet().emailAddress();
//       String randomPassword = faker.internet().password();

        LoginUserPayload loginUser = new LoginUserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");
        LoginResponse loginResponse = userApiService.loginUser(loginUser)
                .shouldHave(Conditions.statusCode(200))
                .asPojo(LoginResponse.class);

        assertThat(loginResponse.getAccessToken())
                .as("Access token должен быть не пустым")
                .isNotNull()
                .isNotEmpty();
    }
}
