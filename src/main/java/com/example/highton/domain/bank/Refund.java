package com.example.highton.domain.bank;

import com.example.highton.domain.account.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long point;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Refund(Long point, Account account) {
        this.point = point;
        this.account = account;
    }
}
