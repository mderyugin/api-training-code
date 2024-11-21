package com.cinema.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class MoviesPage {

    public static MoviesPage open() {
        Selenide.open("https://dev-cinescope.store/movies");
        return page(MoviesPage.class);
    }

    public MoviesPage openMovie() {
        ElementsCollection moreDetailsButtons = $$x("//a[contains(@href, '/movies/')]/button");
        if (!moreDetailsButtons.isEmpty()) {
            int randomIndex = new Random().nextInt(moreDetailsButtons.size());
            moreDetailsButtons.get(randomIndex).click();
            Selenide.sleep(2000);
        }
        else
        {
            throw new IllegalStateException("Not Exist");
        }
        return this;
    }
}

