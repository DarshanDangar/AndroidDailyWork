package com.example.doctorchanneling.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.doctorchanneling.R
import com.example.doctorchanneling.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navigationController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navigationController)
        setSupportActionBar(binding.toolbar)
        this.supportActionBar?.apply {
            if (navigationController.currentDestination?.id == R.id.home) {
//                setDisplayHomeAsUpEnabled(true)
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(false)
                setDisplayShowHomeEnabled(false)
            } else {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowTitleEnabled(false)
                setHomeAsUpIndicator(R.drawable.btn_back)
            }
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//            setDisplayShowTitleEnabled(false)
//            setHomeAsUpIndicator(R.drawable.btn_back)
        // Hide the app name or title
        }
        navigationController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.tvToolbarName.text = destination.label
            if (destination.id == R.id.chat) {
                binding.toolbar.menu.clear()
                binding.toolbar.inflateMenu(R.menu.chat_menu)
            } else {
                binding.toolbar.menu.clear()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        navigationController  = findNavController(R.id.navigation)
        return navigationController.navigateUp() || super.onSupportNavigateUp()
    }

}