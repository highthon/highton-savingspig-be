package com.example.highton.domain.bank.scheduler;

import com.example.highton.domain.bank.service.RewardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class RewardSchelduler {
    private final RewardService rewardService;

    //@Scheduled(cron = "0 * * * * *")
    @Scheduled(cron = "0 0 0 ? * MON-SUN")
    public void everyWeekChangeStatusReward() {
        rewardService.rewardMoney();
        log.info("everyWeekChangeStatusReward Updated At {}", LocalDateTime.now());
    }
}
