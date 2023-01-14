package com.example.highton.global.security;

import com.example.highton.global.security.auth.AuthDetails;
import com.example.highton.global.security.auth.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthDetailsService authDetailsService;

    private static final String USER_ID_HEADER = "User-Id";

    public String resolveAuthHeader(HttpServletRequest request) {
        return request.getHeader(USER_ID_HEADER);
    }

    public Authentication getAuthentication(String userId) {
        AuthDetails authDetails = authDetailsService.loadUserByUsername(userId);
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

}
