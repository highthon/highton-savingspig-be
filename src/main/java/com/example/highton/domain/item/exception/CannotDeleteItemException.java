package com.example.highton.domain.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "판매 완료된 물품은 삭제할 수 없습니다.")
public class CannotDeleteItemException extends RuntimeException {
}
