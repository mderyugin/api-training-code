package com.cinema.api.assertions;

import com.cinema.api.conditions.Condition;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(Condition condition){
        condition.check(response);
        return this;
    }
    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }
    public Headers headers(){
        return response.getHeaders();
    }
}
