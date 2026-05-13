package com.pritamworld.mvvm_examples.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    val id: Int?,

    val name: String,
    val username: String,
    val email: String
)