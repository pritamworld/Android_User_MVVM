package com.pritamworld.mvvm_examples.network.api

import com.pritamworld.mvvm_examples.network.dto.PostDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("posts/{id}")
    suspend fun getPost(
        @Path("id") id: Int
    ): PostDto

    @POST("posts")
    suspend fun createPost(
        @Body post: PostDto
    ): PostDto

    @PUT("posts/{id}")
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body post: PostDto
    ): PostDto

    @DELETE("posts/{id}")
    suspend fun deletePost(
        @Path("id") id: Int
    ): Response<Unit>
}