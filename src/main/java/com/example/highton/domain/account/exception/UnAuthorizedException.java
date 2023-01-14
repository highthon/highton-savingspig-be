package com.example.highton.domain.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "인가 정보를 확인해 주세요.")
public class UnAuthorizedException extends RuntimeException{
}
