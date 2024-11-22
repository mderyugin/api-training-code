package com.cinema.tests;


import com.cinema.api.assertions.AssertableResponse;
import com.cinema.api.payloads.CardPayload;
import com.cinema.api.payloads.PaymentPayload;
import com.github.javafaker.Faker;
import com.cinema.api.conditions.Conditions;
import com.cinema.api.payloads.LoginUserPayload;
import com.cinema.api.services.UserApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class TestPayment {

    private final UserApiService userApiService = new UserApiService();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://dev-cinescope.store";
    }

    @Test
    public void testUserCanPay() {
        LoginUserPayload loginUser = new LoginUserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.loginUser(loginUser)
                .shouldHave(Conditions.statusCode(201));

        PaymentPayload payment = (PaymentPayload) new PaymentPayload()
                .movieId(76)
                .amount(1)
                .cardPayload(new CardPayload()
                    .cardNumber("4242424242424242")
                    .cardHolder("Bober Andreevich")
                    .expirationDate("12/25")
                    .securityCode(123));

        userApiService.payment(payment)
                .shouldHave(Conditions.statusCode(201));
    }
}
