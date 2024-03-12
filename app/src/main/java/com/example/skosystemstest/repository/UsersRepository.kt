package com.example.skosystemstest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.skosystemstest.db.UserRoomDB
import com.example.skosystemstest.model.UsersList
import com.example.skosystemstest.network.UsersService

class UsersRepository(private val usersServiceInterface: UsersService, private val userDatabase: UserRoomDB) {

    private val usersListLiveData = MutableLiveData<UsersList>()

    val users : LiveData<UsersList>
        get() = usersListLiveData // get() is used to access mutable live data

    // fetching data
    suspend fun getUsersList(page: Int) {
        val result = usersServiceInterface.getUserData(page)
        if (result.body() != null) {
            // add data into room db
            userDatabase.userDao().addUsers(result.body()!!.data)
            usersListLiveData.postValue(result.body())

        }
    }
}