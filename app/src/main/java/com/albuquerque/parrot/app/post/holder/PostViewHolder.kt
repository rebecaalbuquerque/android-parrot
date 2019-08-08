package com.albuquerque.parrot.app.post.holder

import androidx.databinding.ViewDataBinding
import com.albuquerque.parrot.app.post.model.PostUser
import com.albuquerque.parrot.app.post.model.toPost
import com.albuquerque.parrot.app.post.model.toUser
import com.albuquerque.parrot.app.post.view.handler.PostHandler
import com.albuquerque.parrot.core.view.holder.BaseViewHolder
import com.albuquerque.parrot.databinding.ItemPostBinding

class PostViewHolder(var binding: ViewDataBinding) : BaseViewHolder<PostUser>(binding) {

    override fun bind(item: PostUser) {

        with(binding as ItemPostBinding) {
            post = item.toPost()
            user = item.toUser()
            handler = PostHandler
            executePendingBindings()
        }

    }

}