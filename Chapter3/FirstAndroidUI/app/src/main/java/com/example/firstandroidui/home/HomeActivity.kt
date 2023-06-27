package com.example.firstandroidui.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.ActivityHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)


        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navigationController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navigationController)
//        appBarConfiguration = AppBarConfiguration(setOf( R.menu.item_chat,R.menu.item_call, R.menu.item_profile))
//        setSupportActionBar(binding.toolbar)
//        setupActionBarWithNavController(navigationController, appBarConfiguration)
//        binding.bottomNavigation.setupWithNavController(navigationController)

        lifecycleScope.launch {
            navigationController.currentBackStackEntryFlow.collectLatest {
                it.destination.id
                binding.tbName.text = it.destination.label.toString()
                supportFragmentManager.fragments[0].childFragmentManager.addOnBackStackChangedListener {
                    val fragment =
                        supportFragmentManager.fragments[0].childFragmentManager.fragments[0] as? ActivityMenuProvider
                    fragment?.getMenu()?.let {
                        binding.toolbar.menu.clear()
                        binding.toolbar.inflateMenu(it)
                    }
                }
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

}
