package com.cinema.tests;


import com.pages.api.assertions.AssertableResponse;
import com.pages.api.payloads.CardPayload;
import com.pages.api.payloads.PaymentPayload;
import com.pages.api.responses.PaymentResponse;
import com.pages.api.conditions.Conditions;
import com.pages.api.payloads.LoginUserPayload;
import com.pages.api.services.UserApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TestPayment {

    private static final Logger logger = LoggerFactory.getLogger(TestPayment.class);
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

        logger.info("Начинаю тестовую оплату с пользователем {}", loginUser.email());

        AssertableResponse loginResponse = userApiService.loginUser(loginUser);
        loginResponse.shouldHave(Conditions.statusCode(201));

        String accesToken = loginResponse.asPojo(Map.class).get("accessToken").toString();
        assertThat(accesToken)
                .as("Acess token должен быть не пустым")
                .isNotNull()
                .isNotEmpty();

        PaymentPayload payment = new PaymentPayload()
                .movieId(76)
                .amount(1)
                .cardPayload(new CardPayload()
                    .cardNumber("4242424242424242")
                    .cardHolder("Bober Andreevich")
                    .expirationDate("12/25")
                    .securityCode(123));
        logger.debug("Отправленные данные для оплаты: {}", payment);

        AssertableResponse paymentStatus = userApiService.payment(payment);
        paymentStatus.shouldHave(Conditions.statusCode(201));

        PaymentResponse paymentResponse = paymentStatus.asPojo(PaymentResponse.class);
        assertThat(paymentResponse.getStatus())
                .as("Ожидаем, что статус оплаты будет 'SUCCESS'")
                .isEqualTo("SUCCESS");
    }
}
