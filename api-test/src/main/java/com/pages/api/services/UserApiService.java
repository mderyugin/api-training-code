package com.pages.api.services;

import com.pages.api.assertions.AssertableResponse;
import com.pages.api.payloads.LoginUserPayload;
import com.pages.api.payloads.PaymentPayload;
import com.pages.api.responses.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

import static io.restassured.RestAssured.*;

@RequiredArgsConstructor
public class UserApiService extends ApiService {

    private String authToken;

    private <T> T sendRequest(Object payload, String baseUri, String path, String method, Class<T> responseClass) {
        RequestSpecification request = setup()
                .baseUri(baseUri)
                .header("Content-Type", "application/json")
                .body(payload);
                if (authToken != null) {
                    request.header("Authorization", "Bearer " + authToken);
                }
                Response response = request
                .when()
                .request(method, path);

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body().asString());

        return response.then().extract().as(responseClass);
    }

    public AssertableResponse loginUser(LoginUserPayload user) {
        Response response = setup()
                .baseUri("https://auth.dev-cinescope.store")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/login");

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body().asString());

        LoginResponse loginResponse = response.then().extract().as(LoginResponse.class);

        if (loginResponse.getAccessToken() == null) {
            throw new IllegalStateException("Login response does not contain 'accessToken'");
        }
        this.authToken = loginResponse.getAccessToken();

        return new AssertableResponse(response);
    }

    public AssertableResponse payment(PaymentPayload paymentPayload) {
        if (authToken == null) {
            throw new IllegalStateException("Auth token is not set. Please log in.");
        }

        Response response = setup()
                .baseUri(baseURI)
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
