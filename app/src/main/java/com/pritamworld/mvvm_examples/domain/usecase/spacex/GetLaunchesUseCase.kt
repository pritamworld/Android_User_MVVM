package com.pritamworld.mvvm_examples.domain.usecase.spacex

import com.pritamworld.mvvm_examples.domain.repository.SpaceXRepository
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(
    private val repository: SpaceXRepository
) {

    suspend operator fun invoke() = repository.getLaunches()
}