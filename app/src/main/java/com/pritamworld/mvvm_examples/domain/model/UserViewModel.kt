package com.pritamworld.mvvm_examples.domain.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pritamworld.mvvm_examples.domain.usecase.user.CreateUserUseCase
import com.pritamworld.mvvm_examples.domain.usecase.user.DeleteUserUseCase
import com.pritamworld.mvvm_examples.domain.usecase.user.GetUsersUseCase
import com.pritamworld.mvvm_examples.domain.usecase.user.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsers: GetUsersUseCase,
    private val createUser: CreateUserUseCase,
    private val updateUser: UpdateUserUseCase,
    private val deleteUser: DeleteUserUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = getUsers()
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            createUser(user)
            loadUsers()
        }
    }

    fun editUser(id: Int, user: User) {
        viewModelScope.launch {
            updateUser(id, user)
            loadUsers()
        }
    }

    fun removeUser(id: Int) {
        viewModelScope.launch {
            deleteUser(id)
            loadUsers()
        }
    }
}