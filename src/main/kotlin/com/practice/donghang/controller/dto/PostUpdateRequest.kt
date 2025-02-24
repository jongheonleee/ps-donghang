package com.practice.donghang.controller.dto

import com.practice.donghang.service.dto.PostUpdateRequestDto

data class PostUpdateRequest(
    val title: String,
    val content: String,
    val updatedBy: String,
)

fun PostUpdateRequest.toDto() = PostUpdateRequestDto(
    title = this.title,
    content = this.content,
    updatedBy = this.updatedBy
)
