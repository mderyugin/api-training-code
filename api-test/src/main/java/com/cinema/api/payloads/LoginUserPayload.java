package com.cinema.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class LoginUserPayload {
    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

}
