package com.socks.ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MoviesPayPage {

    public static MoviesPayPage open() {
        Selenide.open("https://dev-cinescope.store/movies");
        return page(MoviesPayPage.class);
    }
    public MoviesPayPage buyTicket() {
        ElementsCollection moreDetailsButtons = $$x("//a[contains(@href, '/movies/')]/button");
        $x("//a[contains(@href, '/payment?movieId=527')]").click();
        $x("//*[@min and @max]");

        return this;
    }

}

