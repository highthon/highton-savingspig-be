package com.example.highton.domain.account.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.exception.AccountNotFoundException;
import com.example.highton.domain.account.exception.PasswordNotMatchedException;
import com.example.highton.domain.account.exception.UnAuthorizedException;
import com.example.highton.domain.account.presentation.dto.request.SignInRequest;
import com.example.highton.domain.account.presentation.dto.response.SignInResponse;
import com.example.highton.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account getAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new UnAuthorizedException();
        }

        return accountRepository.findByUserId(authentication.getName())
                .orElseThrow(AccountNotFoundException::new);
    }
    
    public SignInResponse signIn(SignInRequest signInRequest) {
        Account user = accountRepository.findByUserId(signInRequest.getUserId())
                .orElseThrow(() -> new AccountNotFoundException());
        if(!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new PasswordNotMatchedException();
        }
        return new SignInResponse(user.getUserId());
    }
    
}
