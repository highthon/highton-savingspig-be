package com.example.highton.domain.account.presentation.dto.request;

import lombok.Getter;

@Getter
public class SignInRequest {
    private String userId;
    private String password;
}
