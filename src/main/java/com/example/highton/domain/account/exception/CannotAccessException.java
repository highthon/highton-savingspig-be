package com.example.highton.domain.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "접근 권한이 없습니다.")
public class CannotAccessException extends RuntimeException {
}
