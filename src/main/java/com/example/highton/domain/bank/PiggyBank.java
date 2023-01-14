package com.example.highton.domain.bank;

import com.example.highton.domain.account.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
public class PiggyBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long point;

    private Integer percentage = DEFAULT_PERCENTAGE;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
    public static final Integer DEFAULT_PERCENTAGE = 10;

    public PiggyBank(Long point, LocalDateTime startDate) {
        this.point = point;
        this.startDate = startDate;
        if (Objects.nonNull(startDate)) {
            this.endDate = startDate.plusMonths(6);
        }
    }

    public void updatePercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void resetPiggyBank() {
        this.point = null;
        this.startDate = null;
        this.endDate = null;
    }

    public void plusPoint(Long point) {
        this.point += point;
    }

}
