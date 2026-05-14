package com.pritamworld.mvvm_examples.domain.repository

import com.pritamworld.mvvm_examples.domain.model.Post
import kotlinx.coroutines.flow.Flow
import com.pritamworld.mvvm_examples.core.common.Result
interface PostRepository {

    fun getPosts(): Flow<Result<List<Post>>>

    suspend fun createPost(post: Post): Result<Post>

    suspend fun updatePost(
        id: Int,
        post: Post
    ): Result<Post>

    suspend fun deletePost(id: Int): Result<Unit>

    suspend fun syncPosts()
}