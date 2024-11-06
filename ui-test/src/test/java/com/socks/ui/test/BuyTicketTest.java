package com.socks.ui.test;

import com.socks.api.conditions.Condition;
import com.socks.ui.MoviesPage;
import com.socks.ui.MoviesPayPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

public class BuyTicketTest extends  BaseUiTest {
    @Test
    public void userCantBuyTicketWithWrongCredentials() {
        MoviesPage.open()
            .openMovie();
            at(MoviesPayPage.class);
    }
}
