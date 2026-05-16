package com.pages.api.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCodeCondition implements ICondition {

    private final int statusCode;
    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);

    }
}
