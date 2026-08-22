package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) {

        http.authorizeHttpRequests(request -> request
                        .requestMatchers("/home", "/privacy-policy", "/sign-up").permitAll()
                        .requestMatchers("/admin/**").denyAll()
                        .requestMatchers("/payment/**").fullyAuthenticated()
                        .anyRequest().authenticated())
                .formLogin(korm -> korm
                        .loginPage("/sign-in")
                        .usernameParameter("mobile")
                        .passwordParameter("pass")
                        .defaultSuccessUrl("/", true)
                        .permitAll()

                )
                .logout(Customizer.withDefaults())
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}
