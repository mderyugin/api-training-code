package com.socks.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.ConnectionBuilder;

@Getter
@Setter
@Accessors(fluent = true)
public class UserPayload {
    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

}
