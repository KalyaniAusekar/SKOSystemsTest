package com.example.skosystemstest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skosystemstest.R
import com.example.skosystemstest.model.User
import com.example.skosystemstest.model.UsersList
import com.squareup.picasso.Picasso

class UserPaginationAdapter(private val user: ArrayList<UsersList>) :
    RecyclerView.Adapter<UserPaginationAdapter.UserHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_user_data, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        val userData = user[position].data
        holder.firstName.text = userData[position].first_name
        holder.firstName.text = userData[position].last_name
        holder.userEmail.text = userData[position].email

        Picasso.get().load(userData[position].avatar).into(holder.user_img)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    class UserHolder(view: View): RecyclerView.ViewHolder(view) {

        val firstName = view.findViewById<TextView>(R.id.firstName)
        val userEmail = view.findViewById<TextView>(R.id.userEmail)
        val user_img = view.findViewById<ImageView>(R.id.user_img)
    }
}