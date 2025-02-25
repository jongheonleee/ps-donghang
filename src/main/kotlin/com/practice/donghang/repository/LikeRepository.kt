package com.practice.donghang.repository

import com.practice.donghang.domain.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository : JpaRepository<Like, Long>
