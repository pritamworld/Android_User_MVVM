package com.pritamworld.mvvm_examples.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pritamworld.mvvm_examples.domain.usecase.post.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import com.pritamworld.mvvm_examples.core.common.Result
@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    val posts = getPostsUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            Result.Loading
        )
}