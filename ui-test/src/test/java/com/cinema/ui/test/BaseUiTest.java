package com.cinema.ui.test;

import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseUiTest {
    @BeforeEach
    public void setUp() {
    }

    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
