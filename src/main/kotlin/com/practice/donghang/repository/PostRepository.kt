package com.practice.donghang.repository

import com.practice.donghang.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun title(title: String): MutableList<Post>
}
