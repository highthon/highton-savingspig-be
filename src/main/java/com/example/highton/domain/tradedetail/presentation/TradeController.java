package com.example.highton.domain.tradedetail.presentation;

import com.example.highton.domain.tradedetail.presentation.request.TradeRequest;
import com.example.highton.domain.tradedetail.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "구매 API")
@RequiredArgsConstructor
@RequestMapping("/trade")
@RestController
public class TradeController {

    private final TradeService tradeService;

    @Operation(summary = "구매")
    @PostMapping
    public void trade(@RequestBody @Valid TradeRequest request) {
        tradeService.trade(request);
    }

}
