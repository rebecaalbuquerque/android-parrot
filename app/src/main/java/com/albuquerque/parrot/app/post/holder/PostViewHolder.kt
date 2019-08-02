package com.albuquerque.parrot.app.post.holder

import androidx.databinding.ViewDataBinding
import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.holder.BaseViewHolder
import com.albuquerque.parrot.databinding.ItemPostBinding

class PostViewHolder(var binding: ViewDataBinding): BaseViewHolder<Post>(binding) {

    override fun bind(item: Post) {

        with(binding) {
            (this as ItemPostBinding).post = item
            executePendingBindings()
        }

    }

}