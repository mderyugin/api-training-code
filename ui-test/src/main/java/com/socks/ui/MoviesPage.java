package com.socks.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class MoviesPage {

    public static MoviesPage open() {
        Selenide.open("https://dev-cinescope.store/movies");
        return page(MoviesPage.class);
    }

    public MoviesPage openMovie() {
        Selenide.sleep(2000);
        ElementsCollection moreDetailsButtons = $$x("//a[contains(@href, '/movies/')]/button");
        Selenide.sleep(2000);
        if (!moreDetailsButtons.isEmpty()) {
            int randomIndex = new Random().nextInt(moreDetailsButtons.size());
            moreDetailsButtons.get(randomIndex).click();
            Selenide.sleep(2000);
        }
        else
        {
            throw new IllegalStateException("Не существует");
        }
        return this;
    }
}

