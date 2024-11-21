package com.cinema.api.services;

import com.cinema.api.assertions.AssertableResponse;
import com.cinema.api.payloads.LoginUserPayload;
import com.cinema.api.payloads.PaymentPayload;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserApiService extends ApiService {

    public AssertableResponse loginUser(LoginUserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .get("login"));
    }
    public AssertableResponse payment(PaymentPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .get("success"));
    }
}
