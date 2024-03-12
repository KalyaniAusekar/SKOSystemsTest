package com.example.skosystemstest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skosystemstest.repository.UsersRepository

class UsersViewModelFactory(private val usersRepository: UsersRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(usersRepository) as T
    }

}