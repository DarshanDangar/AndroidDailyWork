package com.example.firstandroidui

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstandroidui.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_call)
        val iteamDecoration = VerticalSpaceItemDecoration(8)
        binding.rvCall.addItemDecoration(iteamDecoration)
        binding.rvCall.adapter = CallAdapter(DataCallList.listofCall)
    }
}

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = verticalSpaceHeight
    }

}

