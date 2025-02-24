package com.practice.donghang.controller.dto

data class CommentResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: String,
    val comments: List<CommentResponse> = emptyList(),
)

fun PostDetailResponse.toResponse() = PostDetailResponse(
    id = id,
    title = title,
    content = content,
    createdBy = createdBy,
    createdAt = createdAt,
    comments = comments
)
