package com.rafael_dev.ecomerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean //configuramos el comportamiento de acceso a nuestros endpoints
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))//deshabilitamos puesto que no vamos a trabajar con formularios
                .authorizeHttpRequests((auth) -> {

                            auth.anyRequest().authenticated();
                })
                .sessionManagement((session) -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean  /* creamos un usuario en memoria para la autenticacion basica, este usuario sera administrado por el objeto AuthenticationManager */
    UserDetailsService userDetailsService(){

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("rafael")
                .password("1234")
                .roles()
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean //Objeto encargado de encriptar contraseñas
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean //Objeto encargado de adminitrar las autenticaciones
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }
}
