package com.cinema.ui;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:payment.properties")
public interface IPaymentConfig extends Config {
    @Key("card.number")
    String cardNumber();

    @Key("card.cardholderName")
    String cardholderName();

    @Key("card.expiryMonth")
    String month();

    @Key("card.expiryYear")
    String year();

    @Key("card.cvc")
    String cvc();
}
