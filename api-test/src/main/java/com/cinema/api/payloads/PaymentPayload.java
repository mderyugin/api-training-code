package com.cinema.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class PaymentPayload {
        @JsonProperty("movieId")
        private String moveId;

        @JsonProperty("amount")
        private String amount;

        @JsonProperty("cardPayload")
        private CardPayload cardPayload = new CardPayload();

}
