package com.example.highton.domain.item;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.item.enums.Category;
import com.example.highton.domain.item.enums.SellType;
import com.example.highton.global.entity.base.BaseTimeEntity;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long price;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 20, nullable = false)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 6, nullable = false)
    private SellType sellType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> imageList = new ArrayList<>();

    public Item(Long price, String title, String description, Category category, SellType sellType, Account account) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.category = category;
        this.sellType = sellType;
        this.account = account;
    }
}
