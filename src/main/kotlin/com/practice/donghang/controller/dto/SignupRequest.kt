package com.practice.donghang.controller.dto

data class SignupRequest(
    val email: String,
    val password: String,
    val createdBy: String,
)
