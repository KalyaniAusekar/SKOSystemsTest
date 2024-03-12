package com.example.skosystemstest.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.skosystemstest.db.UserDao
import com.example.skosystemstest.model.User
import com.example.skosystemstest.model.UsersList

class UserPaginSource(private val dao: UserDao):PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        TODO("Not yet implemented")
    }


}