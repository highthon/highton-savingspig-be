package com.example.highton.domain.bank;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.bank.enums.BankType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 9, nullable = false)
    @Enumerated(EnumType.STRING)
    private BankType bank;

    @Column(length = 30, nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public BankAccount(String username, BankType bank, String number) {
        this.username = username;
        this.bank = bank;
        this.number = number;
    }
}
