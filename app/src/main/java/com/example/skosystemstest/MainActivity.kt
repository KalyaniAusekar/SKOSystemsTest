package com.example.skosystemstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skosystemstest.ui.adapter.UserPaginationAdapter
import com.example.skosystemstest.databinding.ActivityMainBinding
import com.example.skosystemstest.model.User
import com.example.skosystemstest.model.UsersList
import com.example.skosystemstest.network.RetrofitApiClient
import com.example.skosystemstest.network.UsersService
import com.example.skosystemstest.viewModel.UsersViewModel
import com.example.skosystemstest.viewModel.UsersViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var userPaginationAdapter: UserPaginationAdapter? = null

    var usersViewModel: UsersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userApiService = RetrofitApiClient.getInstace().create(UsersService::class.java)
        // print data for testing
       GlobalScope.launch {
            val result = userApiService.getUserData(1)
            if (result != null) {
                Log.d("TAG", "onCreate: result ${result.body().toString()}")
            }
        }

        val usersRepository = (application as UsersApplication).usersRepository
        usersViewModel = ViewModelProvider(this, UsersViewModelFactory(usersRepository))[UsersViewModel::class.java]

        usersViewModel!!.users.observe(this, Observer {
            Log.d("TAG", "onCreate: users data ${it.data.toString()}")
        })

        initViews()
    }

    private fun initViews() {

        binding.userRecyclerView.layoutManager = LinearLayoutManager(this)
        val usersData = ArrayList<UsersList>()

        usersViewModel!!.users.observe(this) {
            userPaginationAdapter = UserPaginationAdapter(usersData)
            binding.userRecyclerView.adapter = userPaginationAdapter
        }
    }


   /* private fun getAllDev() {
        ///get the list of dev from api response
        usersViewModel!!.users.observe(this,
            Observer<List<User>> { usersViewModel ->
                ///if any thing chnage the update the UI
                userPaginationAdapter?.setDeveloperList(mDeveloperModel as ArrayList<DeveloperModel>)
                loadBar?.visibility = View.GONE
            })
    }*/

}