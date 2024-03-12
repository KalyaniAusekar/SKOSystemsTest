package com.example.skosystemstest.network

import com.example.skosystemstest.model.UsersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("api/users")
    suspend fun getUserData(@Query("page") page : Int) : Response<UsersList>
}