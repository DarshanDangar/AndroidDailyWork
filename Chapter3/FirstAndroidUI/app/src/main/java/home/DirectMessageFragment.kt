package home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentChannelsBinding
import com.example.firstandroidui.databinding.FragmentDirectMessageBinding

class DirectMessageFragment : Fragment() {
    lateinit var binding: FragmentDirectMessageBinding
    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    binding = FragmentDirectMessageBinding.inflate(inflater, container, false)
    return binding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateChat.text = "Start your first chat"
    }
}