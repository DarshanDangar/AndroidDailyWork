package com.example.firstandroidui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentCallBinding
import com.example.firstandroidui.home.ActivityMenuProvider
import com.example.firstandroidui.home.adapter.CallAdapter
import com.example.firstandroidui.home.DataCallList

class CallFragment : Fragment(), ActivityMenuProvider
{

    private lateinit var binding: FragmentCallBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_call, container, false)
        binding.rvCall.adapter = CallAdapter(DataCallList.listofCall)
        return binding.root
    }

    override fun getMenu(): Int = R.menu.item_call

}