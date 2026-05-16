package com.pages.api.conditions;

import io.restassured.response.Response;

public interface ICondition {

    void  check(Response response);
}
