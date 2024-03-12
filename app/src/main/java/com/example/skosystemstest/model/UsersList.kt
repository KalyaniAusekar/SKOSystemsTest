package com.example.skosystemstest.model

data class UsersList(
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)