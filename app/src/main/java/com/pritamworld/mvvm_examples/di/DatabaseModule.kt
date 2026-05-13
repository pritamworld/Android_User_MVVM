package com.pritamworld.mvvm_examples.di

import android.content.Context
import androidx.room.Room
import com.pritamworld.mvvm_examples.db.AppDatabase
import com.pritamworld.mvvm_examples.db.dao.PostDao
import com.pritamworld.mvvm_examples.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database.db"
        ).build()
    }

    @Provides
    fun provideUserDao(
        db: AppDatabase
    ): UserDao {
        return db.userDao()
    }

    @Provides
    fun providePostDao(
        db: AppDatabase
    ): PostDao {
        return db.postDao()
    }
}