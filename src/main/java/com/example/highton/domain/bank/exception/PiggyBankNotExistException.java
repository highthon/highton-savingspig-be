package com.example.highton.domain.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "PiggyBank Not ExistException")
public class PiggyBankNotExistException extends RuntimeException {
}
