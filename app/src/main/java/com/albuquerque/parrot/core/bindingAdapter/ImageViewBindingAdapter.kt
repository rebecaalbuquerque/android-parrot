package com.albuquerque.parrot.core.bindingAdapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop


@BindingAdapter("src", "placeholder")
fun loadImage(imageView: ImageView, src: String?, drawable: Drawable) {

    Glide
        .with(imageView.context)
        .load(src)
        .placeholder(drawable)
        .transform(CircleCrop())
        .into(imageView)
}