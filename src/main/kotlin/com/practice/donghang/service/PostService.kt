package com.practice.donghang.service

import com.practice.donghang.exception.PostNotDeletableException
import com.practice.donghang.exception.PostNotFoundException
import com.practice.donghang.repository.PostRepository
import com.practice.donghang.service.dto.PostCreateRequestDto
import com.practice.donghang.service.dto.PostDetailResponseDto
import com.practice.donghang.service.dto.PostSearchRequestDto
import com.practice.donghang.service.dto.PostSummaryResponseDto
import com.practice.donghang.service.dto.PostUpdateRequestDto
import com.practice.donghang.service.dto.toDetailResponseDto
import com.practice.donghang.service.dto.toEntity
import com.practice.donghang.service.dto.toSummaryResponseDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
    private val likeService: LikeService,
) {

    @Transactional
    fun createPost(requestDto: PostCreateRequestDto): Long {
        return postRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun updatePost(id: Long, requestDto: PostUpdateRequestDto): Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotFoundException()
        post.update(requestDto)
        return id
    }

    @Transactional
    fun deletePost(id: Long, deletedBy: String): Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotFoundException()
        if (post.createdBy != deletedBy) throw PostNotDeletableException()
        postRepository.delete(post)
        return id
    }

    fun getPost(id: Long): PostDetailResponseDto {
        val likeCount = likeService.countLike(id)
        return postRepository.findByIdOrNull(id)?.toDetailResponseDto(likeCount) ?: throw PostNotFoundException()
    }

    fun findPageBy(pageRequest: Pageable, postSearchRequestDto: PostSearchRequestDto): Page<PostSummaryResponseDto> {
        return postRepository.findPageBy(pageRequest, postSearchRequestDto)
            .toSummaryResponseDto(likeService::countLike)
    }
}
