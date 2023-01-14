package com.example.highton.domain.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason= "물품을 찾을 수 없습니다.")
public class ItemNotFoundException extends RuntimeException{
}
