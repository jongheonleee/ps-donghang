package com.practice.donghang.controller

import com.practice.donghang.service.LikeService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
class LikeController(
    private val likeService: LikeService,
) {

    @PostMapping("/posts/{postId}/likes")
    fun createLike(
        @PathVariable postId: Long,
        @RequestParam createdBy: String,
    ): Long {
        return likeService.createLike(postId, createdBy)
    }
}
