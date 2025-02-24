package com.practice.donghang.service.dto

import com.practice.donghang.domain.Comment
import com.practice.donghang.domain.Post

data class CommentCreateRequestDto(
    val content: String,
    val createdBy: String,
)

fun CommentCreateRequestDto.toEntity(post: Post) = Comment(
    content = this.content,
    createdBy = this.createdBy,
    post = post
)
