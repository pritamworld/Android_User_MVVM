package com.pritamworld.mvvm_examples.domain.repository

import com.pritamworld.mvvm_examples.network.api.PostApi
import com.pritamworld.mvvm_examples.network.dto.toDomain
import com.pritamworld.mvvm_examples.network.dto.toDto
import com.pritamworld.mvvm_examples.network.dto.toEntity
import com.pritamworld.mvvm_examples.core.common.networkBoundResource
import com.pritamworld.mvvm_examples.db.dao.PostDao
import com.pritamworld.mvvm_examples.model.Post
import com.pritamworld.mvvm_examples.core.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.pritamworld.mvvm_examples.core.common.Result
import kotlinx.coroutines.flow.map

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi,
    private val dao: PostDao
) : PostRepository {

    override fun getPosts(): Flow<Result<List<Post>>> {

        return networkBoundResource(

            query = {
                dao.getPosts().map { entities ->
                    entities.map { it.toDomain() }
                }
            },

            fetch = {
                api.getPosts()
            },

            saveFetchResult = { response ->

                dao.clearPosts()

                dao.insertPosts(
                    response.map { it.toEntity() }
                )
            }
        )
    }

    override suspend fun createPost(
        post: Post
    ): Result<Post> {

        return safeApiCall {

            val response = api.createPost(post.toDto())

            dao.insertPost(response.toEntity())

            response.toEntity().toDomain()
        }
    }

    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Result<Post> {

        return safeApiCall {

            val response = api.updatePost(id, post.toDto())

            dao.insertPost(response.toEntity())

            response.toEntity().toDomain()
        }
    }

    override suspend fun deletePost(
        id: Int
    ): Result<Unit> {

        return safeApiCall {
            api.deletePost(id)
        }
    }
}