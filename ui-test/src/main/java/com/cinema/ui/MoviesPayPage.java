package com.cinema.ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MoviesPayPage {
    IPaymentConfig config = ConfigFactory.create(IPaymentConfig.class);
    private final String priceButton = "//a[contains(@href, 'payment?movieId')]";

    public MoviesPayPage buyTicket() {
        ElementsCollection moreDetailsButtons = $$x("//a[contains(@href, '/movies/')]/button");
        $x(priceButton).click();

        var amountField = $x("//input[@id='amount']");
        amountField.setValue("2");


        var cardNumberField = $x("//input[@id='card.cardNumber']");
        cardNumberField.shouldBe(visible).setValue(config.cardNumber());
        Selenide.sleep(2000);

        var cardholderNameField = $x("//input[@id='card.cardholderName']");
        cardholderNameField.setValue(config.cardholderName());
        Selenide.sleep(2000);

        var monthField = $x("//button[@id='month']");
        monthField.selectOptionByValue(config.month());
        actions().sendKeys(Keys.ENTER).perform();
        Selenide.sleep(2000);

        var yearField = $x("//button[@id='year']");
        yearField.selectOptionByValue(config.year());
        actions().sendKeys(Keys.ENTER).perform();

        Selenide.sleep(2000);
        var cvcField = $x("//input[@id='cvc']");
        cvcField.setValue(config.cvc());
        Selenide.sleep(2000);
        return this;
    }

}

