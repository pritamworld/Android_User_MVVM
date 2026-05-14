package com.pritamworld.mvvm_examples.domain.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pritamworld.mvvm_examples.domain.usecase.spacex.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.pritamworld.mvvm_examples.core.common.Result

//sealed interface Result {
//    object Loading: Result
//    data class Success(val launches: List<Launch>): Result
//    data class Error(val message: String): Result
//}

@HiltViewModel
class SpaceXViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<Result<List<Launch>>>(
            Result.Loading
        )

    val state = _state.asStateFlow()

    init {
        loadLaunches()
    }

    private fun loadLaunches() {

        viewModelScope.launch {

            _state.value = Result.Loading

            _state.value = getLaunchesUseCase()
        }
    }
}