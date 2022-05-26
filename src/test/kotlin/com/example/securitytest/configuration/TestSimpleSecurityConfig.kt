package com.example.securitytest.configuration

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@TestConfiguration
class TestSimpleSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? =
        http
            .authorizeHttpRequests { authz ->
                authz
                    .antMatchers("/secure/**").permitAll()
            }.httpBasic(withDefaults())
            .build()

}