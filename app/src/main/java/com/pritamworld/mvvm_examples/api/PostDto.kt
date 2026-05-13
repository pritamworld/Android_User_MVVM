package com.pritamworld.mvvm_examples.api

import com.pritamworld.mvvm_examples.db.entity.PostEntity
import com.pritamworld.mvvm_examples.model.Post

data class PostDto(
    val userId: Int,
    val id: Int?,
    val title: String,
    val body: String
)


fun PostDto.toEntity() = PostEntity(
    userId = userId,
    id = id ?: 0,
    title = title,
    body = body
)

fun PostEntity.toDomain() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun Post.toDto() = PostDto(
    userId = userId,
    id = id,
    title = title,
    body = body
)