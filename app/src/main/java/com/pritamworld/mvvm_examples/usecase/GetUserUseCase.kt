package com.pritamworld.mvvm_examples.usecase

import com.pritamworld.mvvm_examples.repository.UserRepository
import jakarta.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(id: Int) = repo.getUser(id)
}