package com.practice.donghang.service.dto

import com.practice.donghang.domain.Comment

data class CommentResponseDto(
    val id: Long,
    val content: String,
    val createdBy: String,
    val createdAt: String,
    val comments: List<CommentResponseDto> = emptyList(),
)

fun Comment.toResponseDto() = CommentResponseDto(
    id = id,
    content = content,
    createdBy = createdBy,
    createdAt = createdAt.toString()
)
