package com.example.highton.domain.tradedetail.presentation.request;

import com.example.highton.domain.tradedetail.enums.BuyType;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TradeRequest {

    @NotNull
    private Long itemId;

    @NotNull
    private BuyType buyType;

}
