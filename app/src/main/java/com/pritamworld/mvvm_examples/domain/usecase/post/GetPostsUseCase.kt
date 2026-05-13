package com.pritamworld.mvvm_examples.domain.usecase.post

import com.pritamworld.mvvm_examples.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke() = repository.getPosts()
}