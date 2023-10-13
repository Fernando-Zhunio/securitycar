/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author FZHUNIO
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user1 = User.withUsername("fzhunio@novicompu.com")
                .password("{noop}fernando1991")
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("fzhunio@hotmail.com")
                .password("{noop}fernando1991")
                .roles("USER", "ADMIN")
                .build();
        UserDetails[] users = { user1, user2 };
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> {
                    auth.requestMatchers("@/v1/").authenticated();
                    // auth.anyRequest().authenticated();
                })
                .formLogin(form -> {
                    form.successHandler(successHandler());
                    // form.loginPage("/authentication/login").permitAll();
                    form.permitAll();
                });
        // .logout(logout -> {
        // logout.logoutSuccessUrl("/authentication/login");
        // });
        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
            // session.invalidSessionUrl("/authentication/login");
            session.maximumSessions(2);
            session.sessionFixation().migrateSession();
            session.invalidSessionUrl("/authentication/login");
        });

        // http.httpBasic(basic -> {
        // basic.realmName("SecurityCar");
        // basic.authenticationEntryPoint((request, response, authException) -> {
        // response.sendRedirect("/v1/index");
        // });
        // });

        return http.build();
    }

    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            response.sendRedirect("/v1/index");
        };
    }

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)
            throws Exception {
        AuthenticationManagerBuilder config = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        config.userDetailsService(userDetailService()).passwordEncoder(passwordEncoder);
        return config.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
