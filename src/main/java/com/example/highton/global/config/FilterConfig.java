package com.example.highton.global.config;

import com.example.highton.domain.account.repository.AccountRepository;
import com.example.highton.global.security.AuthFilter;
import com.example.highton.global.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final AuthService authService;

    @Override
    public void configure(HttpSecurity builder) {
        builder.addFilterBefore(new AuthFilter(authService), UsernamePasswordAuthenticationFilter.class);
    }

}
