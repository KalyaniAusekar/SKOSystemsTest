package com.example.skosystemstest.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.skosystemstest.model.User
import com.example.skosystemstest.model.UsersList

@Dao

interface UserDao {

    @Insert
    suspend fun addUsers(user: List<User>)

    @Query("SELECT * FROM users")
    suspend fun getUsers() : List<UsersList>
}