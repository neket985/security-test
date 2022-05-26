package com.example.securitytest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/secure")
class SimpleController {

    @GetMapping("simple")
    fun simple() = "hy from secure"

}