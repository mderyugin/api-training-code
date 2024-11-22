package com.cinema.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardPayload {
    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("cardHolder")
    private String cardHolder;

    @JsonProperty("expirationDate")
    private String expirationDate;

    @JsonProperty("securityCode")
    private int securityCode;
}
