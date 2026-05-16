package com.pages.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    private String accessToken;
    private String message;
    private String error;
    private int statusCode;
}
