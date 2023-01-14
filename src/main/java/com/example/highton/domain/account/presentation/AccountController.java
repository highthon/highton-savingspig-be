package com.example.highton.domain.account.presentation;

import com.example.highton.domain.account.presentation.dto.request.SignInRequest;
import com.example.highton.domain.account.presentation.dto.response.SignInResponse;
import com.example.highton.domain.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"계정 관련 API"})
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @ApiResponse(code = 404, message = "사용자가 존재하지 않을때 | 비밀번호가 틀렸을때")
    @ApiOperation(value = "아이디 비번을 받아 로그인해주는 API")
    @PostMapping("/signin")
    public SignInResponse login(@RequestBody SignInRequest signInRequest) {
        return accountService.signIn(signInRequest);
    }
}
