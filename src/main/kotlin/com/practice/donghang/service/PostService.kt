package com.practice.donghang.service

import com.practice.donghang.exception.PostNotDeletableException
import com.practice.donghang.exception.PostNotFoundException
import com.practice.donghang.repository.PostRepository
import com.practice.donghang.service.dto.PostCreateRequestDto
import com.practice.donghang.service.dto.PostUpdateRequestDto
import com.practice.donghang.service.dto.toEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun createPost(requestDto: PostCreateRequestDto) : Long {
        return postRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun updatePost(id: Long, requestDto: PostUpdateRequestDto) : Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotFoundException()
        post.update(requestDto)
        return id
    }

    @Transactional
    fun deletePost(id : Long, deletedBy: String) : Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotFoundException()
        if (post.createdBy != deletedBy) throw PostNotDeletableException()
        postRepository.delete(post)
        return id
    }
}
