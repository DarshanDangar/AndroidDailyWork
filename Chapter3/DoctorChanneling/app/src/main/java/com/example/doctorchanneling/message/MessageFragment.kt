package com.example.doctorchanneling.message

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.R
import com.example.doctorchanneling.chat.DataProvider
import com.example.doctorchanneling.databinding.FragmentMessageBinding
import com.example.doctorchanneling.profile.Doctor
import com.example.doctorchanneling.profile.Profile
import com.example.doctorchanneling.profile.ProfileAdapter

class MessageFragment : Fragment(), DataProvider {

    private lateinit var binding: FragmentMessageBinding
    private lateinit var messageAdapter: MessageAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageAdapter = MessageAdapter(Doctor.listOfDoctor, this)
        binding.rvMessage.adapter = messageAdapter
        binding.rvProfile.adapter = ProfileAdapter(Profile.listOfProfile)

        val iteamDecoration = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State,
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    top = 8
                    bottom = 8
                }
            }
        }

        val profileIteamDecoration = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State,
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

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filter(it) }
                return false
            }

        })
    }

    private fun filter(text: String) {
        val filterList: MutableList<Doctor> = mutableListOf()

        for (item in Doctor.listOfDoctor) {
            if (item.name.lowercase().contains(text.lowercase())) {
                filterList.add(item)
            } else {
                messageAdapter.filterList(null)
            }
        }
        if (filterList.isEmpty()) {
            Toast.makeText(requireActivity(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            messageAdapter.filterList(filterList)
        }
    }

    override fun getData(bundleOf: Bundle) {
        val navController = findNavController()
        val destination = navController.graph.findNode(R.id.chat)
        if (destination?.id == R.id.chat) {
            destination.label = bundleOf.getString("userName")
        }
        navController.navigate(R.id.chat)


//        val action = MessageFragmentDirections.actionMessageToChat()
//        findNavController().apply {
//            graph.findNode(R.id.chat)
//            navigate(action)
//        }
    }

}