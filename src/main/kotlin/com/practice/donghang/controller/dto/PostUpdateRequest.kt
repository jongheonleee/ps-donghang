package com.practice.donghang.controller.dto

data class PostUpdateRequest(
    val title: String,
    val content: String,
    val updatedBy: String,
)
