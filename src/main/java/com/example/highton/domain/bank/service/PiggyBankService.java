package com.example.highton.domain.bank.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.bank.PiggyBank;
import com.example.highton.domain.bank.repository.PiggyBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class PiggyBankService {

    private final PiggyBankRepository piggyBankRepository;

    public void savePoint(Account account, Long price) {
        PiggyBank piggyBank = piggyBankRepository.findByAccount(account)
                .orElse(null);

        if (Objects.isNull(piggyBank)) {
            piggyBankRepository.save(
                    new PiggyBank(
                            getPoint(price, PiggyBank.DEFAULT_PERCENTAGE),
                            LocalDateTime.now()
                    )
            );
            return;
        }

        piggyBank.plusPoint(
                getPoint(price, piggyBank.getPercentage())
        );
    }

    public long getPoint(Long price, Integer percentage) {
        return (price - (price * percentage / 100));
    }

}
