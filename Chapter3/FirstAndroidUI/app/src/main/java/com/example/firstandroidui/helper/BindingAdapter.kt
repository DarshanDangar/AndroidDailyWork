package com.example.firstandroidui.helper

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("image")
fun ImageView.setImage(@DrawableRes id: Int) {
    setImageDrawable(
        ContextCompat.getDrawable(context, id)
    )
}