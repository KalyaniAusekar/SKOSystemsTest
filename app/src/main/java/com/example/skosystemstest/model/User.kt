package com.example.skosystemstest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
//result
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId : Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val avatar: String
)