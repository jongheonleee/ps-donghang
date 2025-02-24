package com.practice.donghang.repository

import com.practice.donghang.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>
