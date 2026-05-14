package com.pritamworld.mvvm_examples.domain.usecase.user

import com.pritamworld.mvvm_examples.domain.model.User
import com.pritamworld.mvvm_examples.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(user: User) = repo.createUser(user)
}