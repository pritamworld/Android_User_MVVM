package com.pritamworld.mvvm_examples.di

import com.pritamworld.mvvm_examples.api.PostApi
import com.pritamworld.mvvm_examples.api.UserApi
import com.pritamworld.mvvm_examples.db.AppDatabase
import com.pritamworld.mvvm_examples.db.dao.PostDao
import com.pritamworld.mvvm_examples.domain.repository.PostRepository
import com.pritamworld.mvvm_examples.domain.repository.PostRepositoryImpl
import com.pritamworld.mvvm_examples.domain.repository.UserRepository
import com.pritamworld.mvvm_examples.domain.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi =
        retrofit.create(UserApi::class.java)

    @Provides
    fun provideUserRepository(api: UserApi): UserRepository =
        UserRepositoryImpl(api)

    @Provides
    fun providePostRepository(api: PostApi, dao: PostDao): PostRepository =
        PostRepositoryImpl(api, dao)

    @Provides
    fun providePostApi(
        retrofit: Retrofit
    ): PostApi {
        return retrofit.create(PostApi::class.java)
    }


}