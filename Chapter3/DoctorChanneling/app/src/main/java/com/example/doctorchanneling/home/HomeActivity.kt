package com.example.doctorchanneling.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.doctorchanneling.R
import com.example.doctorchanneling.databinding.ActivityHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.btn_back)
        lifecycleScope.launch {
            navController.currentBackStackEntryFlow.collectLatest {
                supportActionBar?.apply {
                    if (it.destination.id == R.id.home) {
                        setHomeButtonEnabled(false)
                        setDisplayShowTitleEnabled(false)
                        setDisplayHomeAsUpEnabled(false)
                    } else {
                        setHomeButtonEnabled(true)
                        setDisplayHomeAsUpEnabled(true)
                        setDisplayShowTitleEnabled(false)
                    }
                }
            }

        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
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
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}