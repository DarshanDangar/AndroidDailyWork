package home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.firstandroidui.ProvideMenuOnFragment
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.ActivityHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var currentMenu: ProvideMenuOnFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
//        binding.btnFragment1.setOnClickListener {
//            supportFragmentManager.commit {
//                add(binding.fragmentContainer.id, DirectMessageFragment())
////                replace(binding.fragmentContainer.id, DirectMessageFragment())
//            }
//        }

//        binding.btnFragment2.setOnClickListener {
//            supportFragmentManager.commit {
////                R.id.fragment_container
//                add(binding.fragmentContainer.id, ChannelsFragment())
////                replace(binding.fragmentContainer.id, ChannelsFragment())
//            }
//        }

//        binding.bottomNavigation.setOnItemSelectedListener {item ->
//            when (item.itemId) {
//                R.id.item_meeting -> {
//                    supportFragmentManager.commit {
//                        replace(binding.fragmentContainerView.id, MeetingFragment())
//                    }
//                    binding.tbName.text = item.title
//                    binding.tbBtn2.isGone = true
//                    binding.tbBtn.isGone = true
//                    true
//                }
//                R.id.item_chat -> {
//                    supportFragmentManager.commit {
//                        replace(binding.fragmentContainerView.id, ChatFragment())
//                    }
//                    binding.tbName.text = item.title
//                    binding.tbBtn.isGone = false
//                    binding.tbBtn2.isGone = true
//                    binding.tbBtn.setImageResource(R.drawable.img_search)
//                    true
//                }
//                R.id.item_call -> {
//                    supportFragmentManager.commit {
//                        replace(binding.fragmentContainerView.id, CallFragment())
//                    }
//                    binding.tbName.text = item.title
//                    binding.tbBtn.isGone = false
//                    binding.tbBtn2.isGone = false
//                    binding.tbBtn.setImageResource(R.drawable.img_search)
//                    binding.tbBtn2.setImageResource(R.drawable.img_voicemail)
//                    true
//                }
//                R.id.item_profile -> {
//                    supportFragmentManager.commit {
//                        replace(binding.fragmentContainerView.id, ProfileFragment())
//                    }
//                    binding.tbName.text = item.title
//                    binding.tbBtn.isGone = false
//                    binding.tbBtn2.isGone = true
//                    binding.tbBtn.setImage Resource(R.drawable.img_setting)
//                    true
//                }
//
//                else -> false
//            }
//        }
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navigationController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navigationController)


        lifecycleScope.launch {
            navigationController.currentBackStackEntryFlow.collectLatest {
                binding.tbName.text = it.destination.label.toString()
            }
        }

    }

}
