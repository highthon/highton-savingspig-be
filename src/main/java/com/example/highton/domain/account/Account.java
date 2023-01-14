package com.example.highton.domain.account;

import com.example.highton.domain.bank.BankAccount;
import com.example.highton.domain.bank.PiggyBank;
import com.example.highton.domain.bank.Refund;
import com.example.highton.domain.item.Item;
import com.example.highton.global.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String userId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 60, nullable = false)
    private String nickname;

    private String profileImagePath;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
    private BankAccount bankAccount;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
    private PiggyBank piggyBank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Item> itemList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Refund> refundList = new ArrayList<>();

    public Account(String userId, String password, String nickname, String profileImagePath) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.profileImagePath = profileImagePath;
        this.piggyBank = new PiggyBank(null, null);
    }
}
