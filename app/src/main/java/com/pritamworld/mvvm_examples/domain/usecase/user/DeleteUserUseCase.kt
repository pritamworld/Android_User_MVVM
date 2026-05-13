package com.pritamworld.mvvm_examples.domain.usecase.user

import com.pritamworld.mvvm_examples.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repo: UserRepository
) {
    suspend operator fun invoke(id: Int) = repo.deleteUser(id)
}