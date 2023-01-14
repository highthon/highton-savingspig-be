package com.example.highton.domain.bank.service;

import com.example.highton.domain.bank.PiggyBank;
import com.example.highton.domain.bank.Refund;
import com.example.highton.domain.bank.repository.PiggyBankRepository;
import com.example.highton.domain.bank.repository.RefundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final PiggyBankRepository piggyBankRepository;
    private final RefundRepository refundRepository;

    public void rewardMoney() {
        List<PiggyBank> piggyBanks = piggyBankRepository.findAll();
        List<PiggyBank> bankStream = piggyBanks.stream()
                .filter(e -> e.getEndDate().isBefore(LocalDateTime.now())).collect(Collectors.toList());
        if(!bankStream.isEmpty()) {
            bankStream.forEach(piggyBank -> {
                Long point = piggyBank.getPoint();
                Refund refund = new Refund((long) ((point * 0.15) + point), piggyBank.getAccount());
                refundRepository.save(refund);
                piggyBank.resetPiggyBank();
                piggyBankRepository.save(piggyBank);
            });
        }
    }

}
