package com.pages.api.assertions;

import com.pages.api.conditions.ICondition;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(ICondition condition){
        condition.check(response);
        return this;
    }
    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }
    public Headers headers(){
        return response.getHeaders();
    }
    public Response getResponse() {
        return response;
    }
}
