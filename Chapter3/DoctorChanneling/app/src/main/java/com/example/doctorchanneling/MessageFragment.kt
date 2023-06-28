package com.example.doctorchanneling

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    lateinit var binding: FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMessage.adapter = MessageAdapter(Doctor.listOfDoctor)
        binding.rvProfile.adapter = ProfileAdapter(Profile.listOfProfile)
        val iteamDecoration = object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    top = 16
                    bottom = 16
                }
            }
        }

        val profileIteamDecoration = object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    right = 30
                    left = 30
                }
            }
        }

        binding.rvMessage.addItemDecoration(iteamDecoration)
        binding.rvProfile.addItemDecoration(profileIteamDecoration)
    }

}