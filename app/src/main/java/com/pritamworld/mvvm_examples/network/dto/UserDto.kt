package com.pritamworld.mvvm_examples.network.dto

import com.pritamworld.mvvm_examples.model.User

data class UserDto(
    val id: Int?,
    val name: String,
    val username: String,
    val email: String
)

fun UserDto.toDomain() = User(
    id = id ?: 0,
    name = name,
    username = username,
    email = email
)

fun User.toDto() = UserDto(
    id = id,
    name = name,
    username = username,
    email = email
)