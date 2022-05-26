package com.example.securitytest.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SimpleSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? =
        http
            .authorizeHttpRequests { authz ->
                authz
                    .antMatchers("/secure/**").authenticated()
            }.httpBasic(withDefaults())
            .build()

}