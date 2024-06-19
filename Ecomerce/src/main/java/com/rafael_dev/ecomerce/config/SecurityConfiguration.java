package com.rafael_dev.ecomerce.config;

import com.rafael_dev.ecomerce.filter.JwtAuthEntryPoint;
import com.rafael_dev.ecomerce.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider, JwtAuthEntryPoint jwtAuthEntryPoint) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint))
                .authorizeHttpRequests((auth) -> {
                    auth.requestMatchers(HttpMethod.GET, "/api/v1/products/").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/v1/auth/**").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/v1/users/create").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.GET, "/api/v1/users/").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/api/v1/users/update/").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/v1/users/delete").hasAuthority("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
