package com.example.skosystemstest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skosystemstest.model.User
import com.example.skosystemstest.model.UsersList
import com.example.skosystemstest.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(private val usersRepository: UsersRepository) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            usersRepository.getUsersList(1)
        }
    }

    val users : LiveData<UsersList>
        get() = usersRepository.users
}