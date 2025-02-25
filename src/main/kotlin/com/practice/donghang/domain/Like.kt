package com.practice.donghang.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "likes")
class Like(
    post: Post,
    createdBy: String,
) : BaseEntity(createdBy) {

    @Id
    @GeneratedValue
    val id: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    var post: Post = post
        protected set
}
