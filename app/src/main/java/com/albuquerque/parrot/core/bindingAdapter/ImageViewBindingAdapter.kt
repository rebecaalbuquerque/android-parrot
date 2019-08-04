package com.albuquerque.parrot.core.bindingAdapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

@BindingAdapter("src", "placeholder", requireAll = false)
fun loadImage(imageView: ImageView, src: String?, drawable: Drawable?) {

    Glide
        .with(imageView.context)
        .load(src)
        .placeholder(drawable)
        .into(imageView)

}

@BindingAdapter("srcCircle", "placeholderCircle", requireAll = false)
fun loadImageRounded(imageView: ImageView, srcCircle: String?, placeholderCircle: Drawable?) {

    Glide
        .with(imageView.context)
        .load(srcCircle)
        .placeholder(placeholderCircle)
        .transform(CircleCrop())
        .into(imageView)

}