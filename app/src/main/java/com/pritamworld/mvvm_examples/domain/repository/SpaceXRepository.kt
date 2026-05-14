package com.pritamworld.mvvm_examples.domain.repository

import com.pritamworld.mvvm_examples.domain.model.Launch

interface SpaceXRepository {
    suspend fun getLaunches(): Result<List<Launch>>
}