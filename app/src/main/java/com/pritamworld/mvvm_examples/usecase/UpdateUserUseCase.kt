package com.pritamworld.mvvm_examples.usecase

import com.pritamworld.mvvm_examples.model.User
import com.pritamworld.mvvm_examples.repository.UserRepository
import jakarta.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(id: Int, user: User) =
        repo.updateUser(id, user)
}