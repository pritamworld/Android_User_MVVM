package com.pritamworld.mvvm_examples.repository

import com.pritamworld.mvvm_examples.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUser(id: Int): User
    suspend fun createUser(user: User): User
    suspend fun updateUser(id: Int, user: User): User
    suspend fun deleteUser(id: Int)
}