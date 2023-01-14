package com.example.highton.domain.account.repository;

import com.example.highton.domain.account.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByUserId(String userId);
}
