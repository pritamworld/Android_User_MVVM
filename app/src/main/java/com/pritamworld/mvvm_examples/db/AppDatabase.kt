package com.pritamworld.mvvm_examples.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pritamworld.mvvm_examples.db.dao.PostDao
import com.pritamworld.mvvm_examples.db.dao.UserDao
import com.pritamworld.mvvm_examples.db.entity.PostEntity
import com.pritamworld.mvvm_examples.db.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun postDao(): PostDao
}