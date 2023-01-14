package com.example.highton.domain.tradedetail.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.service.AccountService;
import com.example.highton.domain.bank.service.PiggyBankService;
import com.example.highton.domain.item.Item;
import com.example.highton.domain.item.enums.SellType;
import com.example.highton.domain.item.service.ItemService;
import com.example.highton.domain.tradedetail.TradeDetail;
import com.example.highton.domain.tradedetail.enums.BuyType;
import com.example.highton.domain.tradedetail.presentation.request.TradeRequest;
import com.example.highton.domain.tradedetail.repository.TradeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TradeService {

    private final TradeDetailRepository tradeDetailRepository;

    private final AccountService accountService;
    private final ItemService itemService;
    private final PiggyBankService piggyBankService;

    public void trade(TradeRequest request) {
        Account buyer = accountService.getAccount();
        Item item = itemService.getItem(request.getItemId());
        Account seller = item.getAccount();

        TradeDetail tradeDetail = new TradeDetail(
                request.getBuyType(),
                buyer,
                seller,
                item
        );

        //구매 타입이 saving인 경우
        if (BuyType.SAVING.equals(request.getBuyType())) {
            piggyBankService.savePoint(buyer, item.getPrice());
        }

        //판매 타입이 saving인 경우
        if (SellType.SAVING.equals(item.getSellType())) {
            piggyBankService.savePoint(seller, item.getPrice());
        }

        tradeDetailRepository.save(tradeDetail);
    }

}
