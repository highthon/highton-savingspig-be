package com.example.highton.domain.item.presentation.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteItemRequest {

    @NotNull
    private Long itemId;

}
