package com.cinema.ui.test;

import com.cinema.ui.MoviesPage;
import com.cinema.ui.MoviesPayPage;
import org.junit.jupiter.api.Test;

public class BuyTicketTest extends  BaseUiTest {
    @Test
    public void userCantBuyTicketWithWrongCredentials() {
        MoviesPage.open()
            .openMovie();
        new MoviesPayPage()
        .buyTicket();
    }
}
