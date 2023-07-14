package com.example.firstandroidui.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)


        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navigationController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navigationController)

        navigationController.addOnDestinationChangedListener { controller, destination, arguments ->
            val currentFragment =
                navHost.childFragmentManager.primaryNavigationFragment as? ActivityMenuProvider
            currentFragment?.getMenu()?.let {
                binding.toolbar.menu.clear()
                binding.toolbar.inflateMenu(it)
                binding.tbName.text = destination.label.toString()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

}
