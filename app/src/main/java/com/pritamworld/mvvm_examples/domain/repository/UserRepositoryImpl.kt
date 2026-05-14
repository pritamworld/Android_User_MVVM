package com.pritamworld.mvvm_examples.domain.repository

import com.pritamworld.mvvm_examples.network.api.UserApi
import com.pritamworld.mvvm_examples.network.dto.toDomain
import com.pritamworld.mvvm_examples.network.dto.toDto
import com.pritamworld.mvvm_examples.domain.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    override suspend fun getUsers(): List<User> =
        api.getUsers().map { it.toDomain() }

    override suspend fun getUser(id: Int): User =
        api.getUser(id).toDomain()

    override suspend fun createUser(user: User): User =
        api.createUser(user.toDto()).toDomain()

    override suspend fun updateUser(id: Int, user: User): User =
        api.updateUser(id, user.toDto()).toDomain()

    override suspend fun deleteUser(id: Int) {
        api.deleteUser(id)
    }
}