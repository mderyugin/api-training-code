package com.cinema.api.services;

import com.cinema.api.assertions.AssertableResponse;
import com.cinema.api.payloads.LoginUserPayload;
import com.cinema.api.payloads.PaymentPayload;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class UserApiService extends ApiService {


    private String authToken;


    public AssertableResponse loginUser(LoginUserPayload user) {
        AssertableResponse response = new AssertableResponse(setup()
                .baseUri("https://auth.dev-cinescope.store")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/login"));

        Map<String, Object> responseMap = response.asPojo(Map.class);
        if (responseMap.containsKey("accessToken")) {
            this.authToken = responseMap.get("accessToken").toString();
        } else {
            throw new IllegalStateException("Login response does not contain 'accessToken'");
        }
        return response;
    }

    public AssertableResponse payment(PaymentPayload paymentPayload) {
        if (authToken == null) {
            throw new IllegalStateException("Auth token is not set. Please log in.");
        }

        Response response = setup()
                .baseUri("https://payment.dev-cinescope.store")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(paymentPayload)
                .when()
                .post("/create");

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body().asString());

        return new AssertableResponse(response);
    }
}
