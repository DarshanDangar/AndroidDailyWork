package com.example.userlistdemo.ui.users

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userlistdemo.R
import com.example.userlistdemo.databinding.ActivityUserListBinding
import com.example.userlistdemo.utils.SharedPreferenceHelper
import com.example.userlistdemo.ui.authentication.LogInActivity

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.initialize(application)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        val adapter = UserListAdapter()
        binding.rvUserList.adapter = adapter
        binding.rvUserList.addItemDecoration(itemDecoration)
        userViewModel.getUserDetails()
        userViewModel.userDetails.observe(this) {
            userViewModel.userDetails.value?.let { adapter.submitList(it.data) }
        }
        userViewModel.status.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        binding.btnLogout.setOnClickListener {
            SharedPreferenceHelper.putBoolean("signin", false)
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private val itemDecoration = object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State,
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.apply {
                top = 20
                bottom = 20
            }
        }
    }

}