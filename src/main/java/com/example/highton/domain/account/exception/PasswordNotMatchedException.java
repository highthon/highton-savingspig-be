package com.example.highton.domain.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Password Not Matched Exception")
public class PasswordNotMatchedException extends RuntimeException {
}
