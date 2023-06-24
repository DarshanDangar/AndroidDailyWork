package home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
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

        binding.bottomNavigation.setOnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.item_meeting -> {
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainerView.id, MeetingFragment())
                    }
                    binding.tbName.text = item.title
                    binding.tbBtn2.isGone = true
                    binding.tbBtn.isGone = true
                    true
                }
                R.id.item_chat -> {
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainerView.id, ChatFragment())
                    }
                    binding.tbName.text = item.title
                    binding.tbBtn.isGone = false
                    binding.tbBtn2.isGone = true
                    binding.tbBtn.setImageResource(R.drawable.img_search)
                    true
                }
                R.id.item_call -> {
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainerView.id, CallFragment())
                    }
                    binding.tbName.text = item.title
                    binding.tbBtn.isGone = false
                    binding.tbBtn2.isGone = false
                    binding.tbBtn.setImageResource(R.drawable.img_search)
                    binding.tbBtn2.setImageResource(R.drawable.img_voicemail)
                    true
                }
                R.id.item_profile -> {
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainerView.id, ProfileFragment())
                    }
                    binding.tbName.text = item.title
                    binding.tbBtn.isGone = false
                    binding.tbBtn2.isGone = true
                    binding.tbBtn.setImageResource(R.drawable.img_setting)
                    true
                }

                else -> false
            }
        }
    }

}