package com.practice.donghang.service

import com.practice.donghang.exception.CommentNotDeletableException
import com.practice.donghang.exception.CommentNotFoundException
import com.practice.donghang.exception.PostNotFoundException
import com.practice.donghang.repository.CommentRepository
import com.practice.donghang.repository.PostRepository
import com.practice.donghang.service.dto.CommentCreateRequestDto
import com.practice.donghang.service.dto.CommentUpdateRequestDto
import com.practice.donghang.service.dto.toEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
) {

    @Transactional
    fun createComment(postId: Long, createRequestDto: CommentCreateRequestDto): Long {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException()
        return commentRepository.save(createRequestDto.toEntity(post)).id
    }

    @Transactional
    fun updateComment(id: Long, updateRequestDto: CommentUpdateRequestDto): Long {
        val comment = commentRepository.findByIdOrNull(id) ?: throw CommentNotFoundException()
        comment.update(updateRequestDto)
        return comment.id
    }

    @Transactional
    fun deleteComment(id: Long, deletedBy: String): Long {
        val comment = commentRepository.findByIdOrNull(id) ?: throw CommentNotFoundException()
        if (comment.createdBy != deletedBy) {
            throw CommentNotDeletableException()
        }

        commentRepository.delete(comment)
        return id
    }
}
