package com.practice.donghang.controller

import com.practice.donghang.controller.dto.SigninRequest
import com.practice.donghang.controller.dto.SignupRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
class UserController {

    @PostMapping("/user/signup")
    fun signUp(
        @RequestBody signupRequest: SignupRequest,
    ): String {
        println(signupRequest.email)
        println(signupRequest.password)
        return signupRequest.email
    }

    @PostMapping("/user/login")
    fun login(
        @RequestBody signinRequest: SigninRequest,
    ): String {
        println(signinRequest.email)
        println(signinRequest.password)
        return signinRequest.email
    }

    @GetMapping("/user/logout")
    fun logout(): String {
        return "logout"
    }
}
