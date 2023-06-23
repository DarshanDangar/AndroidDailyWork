package home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.indices
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentChatBinding
import com.google.android.material.tabs.TabLayout

class ChatFragment : Fragment() {
    lateinit var binding: FragmentChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView((activity as Activity),R.layout.fragment_chat)
    }
}