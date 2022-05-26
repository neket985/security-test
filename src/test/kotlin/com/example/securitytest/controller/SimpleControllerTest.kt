package com.example.securitytest.controller

import com.example.securitytest.configuration.SimpleSecurityConfig
import com.example.securitytest.configuration.TestSimpleSecurityConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Configuration


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [TestSimpleSecurityConfig::class]
)
internal class SimpleControllerTest {
    @LocalServerPort
    private var port = 0

    @Autowired
    private var restTemplate: TestRestTemplate? = null

    @Test
    fun simple() {
        val response = restTemplate!!.getForObject(
            "http://localhost:$port/secure/simple",
            String::class.java
        )

        assertThat(response).contains("hi")
    }
}