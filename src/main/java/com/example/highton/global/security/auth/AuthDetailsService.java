package com.example.highton.global.security.auth;

import com.example.highton.domain.account.exception.AccountNotFoundException;
import com.example.highton.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public AuthDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        accountRepository.findByUserId(userId)
                .orElseThrow(AccountNotFoundException::new);
        return new AuthDetails(userId);
    }

}
