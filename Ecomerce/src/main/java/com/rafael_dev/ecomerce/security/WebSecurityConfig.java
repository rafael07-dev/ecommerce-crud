package com.rafael_dev.ecomerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.GET, "/api/v1/users/not-secured").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/products").permitAll()
                        // .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                        // .requestMatchers(HttpMethod.GET, "/api/products", "/api/products/{id}").hasAnyRole("ADMIN", "USER")
                        // .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
                        // .requestMatchers(HttpMethod.PUT, "/api/products/{id}").hasRole("ADMIN")
                        // .requestMatchers(HttpMethod.DELETE, "/api/products/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
/*
    @Bean  //creamos un usuario en memoria para la autenticacion basica, este usuario sera administrado por el objeto AuthenticationManager
    UserDetailsService userDetailsService(){

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("rafael")
                .password("1234")
                .roles()
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                PasswordEncoder passwordEncoder) throws Exception {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }*/
}
