package com.example.highton.domain.bank.repository;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.bank.PiggyBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PiggyBankRepository extends JpaRepository<PiggyBank, Long> {
    Boolean existsByAccount(Account account);
    Optional<PiggyBank> findByAccount(Account account);
}
