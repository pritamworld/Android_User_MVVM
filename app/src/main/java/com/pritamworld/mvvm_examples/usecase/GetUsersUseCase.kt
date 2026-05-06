package com.pritamworld.mvvm_examples.usecase

import com.pritamworld.mvvm_examples.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke() = repo.getUsers()
}