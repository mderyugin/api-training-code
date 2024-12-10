package com.pages.api.assertions;

import io.restassured.response.Response;

public class ApiAssertions {
    public static Response assertStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
        return response;
    }
}