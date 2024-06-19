package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.dto.user.LoginUserDto;
import com.rafael_dev.ecomerce.service.AuthenticationService;
import com.rafael_dev.ecomerce.utils.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginUserDto loginUserDto){

        return ResponseEntity.ok(authenticationService.authenticate(loginUserDto));
    }

}
