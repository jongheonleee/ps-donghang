package com.practice.donghang.controller

import com.practice.donghang.controller.dto.CommentCreateRequest
import com.practice.donghang.controller.dto.CommentUpdateRequest
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController {

    @PostMapping("/posts/{postId}/comments")
    fun createComment(
        @PathVariable postId: Long,
        @RequestBody commentCreateRequest: CommentCreateRequest,
    ): Long {
        println(commentCreateRequest.createdBy)
        print(commentCreateRequest.content)

        return 1L
    }

    @PutMapping("/comments/{commentId}")
    fun updateComment(
        @RequestBody commentUpdateRequest: CommentUpdateRequest,
    ): Long {
        println(commentUpdateRequest.content)
        println(commentUpdateRequest.updatedBy)

        return 1L
    }

    @DeleteMapping("/comments/{commentId}")
    fun deleteComment(
        @PathVariable commentId: Long,
        @RequestParam deletedBy: String,
    ): Long {
        println(deletedBy)
        println(commentId)

        return 1L
    }
}
