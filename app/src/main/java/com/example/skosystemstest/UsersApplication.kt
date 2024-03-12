package com.example.skosystemstest

import android.app.Application
import com.example.skosystemstest.db.UserRoomDB
import com.example.skosystemstest.network.RetrofitApiClient
import com.example.skosystemstest.network.UsersService
import com.example.skosystemstest.repository.UsersRepository

class UsersApplication : Application() {

    lateinit var usersRepository: UsersRepository

    override fun onCreate() {
        super.onCreate()
        initializeData()
    }

    private fun initializeData() {
        // return retrofit instance
        val userApiService = RetrofitApiClient.getInstace().create(UsersService::class.java)
        val userDB = UserRoomDB.getRoomInstance(applicationContext)
        usersRepository = UsersRepository(userApiService,userDB)
    }
}