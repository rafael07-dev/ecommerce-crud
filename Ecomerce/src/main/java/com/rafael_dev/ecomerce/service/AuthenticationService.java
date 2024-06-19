package com.rafael_dev.ecomerce.service;

import com.rafael_dev.ecomerce.dto.user.LoginUserDto;
import com.rafael_dev.ecomerce.repository.UserRepository;
import com.rafael_dev.ecomerce.utils.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUserDto.username(),
                loginUserDto.password()
        ));

        var user = userRepository.findByUsername(loginUserDto.username())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(user);

        var expiredToken = jwtService.getExpirationDateFromToken(jwtToken);

        return new LoginResponse(user.getUsername(), jwtToken, expiredToken, true);
    }
}
