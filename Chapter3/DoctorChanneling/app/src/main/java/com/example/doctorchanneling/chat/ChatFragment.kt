package com.example.doctorchanneling.chat

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.R
import com.example.doctorchanneling.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatAdapter = ChatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.rvChat.adapter = chatAdapter
        addAutoGenerateMessage(MessageType.Receiver)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sendButton: ImageButton? = requireActivity().findViewById(R.id.btn_send) as? ImageButton
        sendButton?.setOnClickListener {
            chatAdapter.addChat(
                ChatModel(
                    binding.etSendMessage.text.toString(), MessageType.Sender
                )
            )
            chatAdapter.notifyDataSetChanged()
            binding.etSendMessage.text?.clear()
            addAutoGenerateMessage(MessageType.Receiver)
        }


        val chatItemDecoration = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State,
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    top = 30
                    bottom = 30
                }
            }
        }

        binding.rvChat.addItemDecoration(chatItemDecoration)
    }

    private fun addAutoGenerateMessage(messageType: MessageType) {
        Handler(Looper.getMainLooper()).postDelayed({
            chatAdapter.addChat(
                ChatModel(
                    when (messageType) {
                        MessageType.Receiver -> "Rorem ipsum dolor sit  adipiscing elit."
                        MessageType.Sender -> "ok"
                    }, MessageType.Receiver
                )
            )
            chatAdapter.notifyDataSetChanged()
        }, 2000)
    }

}

interface DataProvider {
    fun getData(bundleOf: Bundle)
}