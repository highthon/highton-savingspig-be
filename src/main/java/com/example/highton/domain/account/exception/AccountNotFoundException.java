package com.example.highton.domain.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Account Not Found Exception")
public class AccountNotFoundException extends RuntimeException {
}
