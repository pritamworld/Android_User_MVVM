package com.pritamworld.mvvm_examples.domain.usecase.user

import com.pritamworld.mvvm_examples.domain.model.User
import com.pritamworld.mvvm_examples.domain.repository.UserRepository
import jakarta.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(id: Int, user: User) =
        repo.updateUser(id, user)
}