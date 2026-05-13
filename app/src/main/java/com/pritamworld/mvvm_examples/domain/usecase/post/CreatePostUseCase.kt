package com.pritamworld.mvvm_examples.domain.usecase.post

import com.pritamworld.mvvm_examples.domain.repository.PostRepository
import com.pritamworld.mvvm_examples.model.Post
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        post: Post
    ) = repository.createPost(post)
}