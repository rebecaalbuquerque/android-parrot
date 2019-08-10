package com.albuquerque.parrot.app.post.holder

import androidx.databinding.ViewDataBinding
import com.albuquerque.parrot.app.post.model.PostUser
import com.albuquerque.parrot.app.post.view.handler.PostHandler
import com.albuquerque.parrot.core.network.BaseNetwork
import com.albuquerque.parrot.core.view.holder.BaseViewHolder
import com.albuquerque.parrot.databinding.ItemPostBinding

class PostViewHolder(var binding: ViewDataBinding) : BaseViewHolder<PostUser>(binding) {

    override fun bind(item: PostUser) {

        with(binding as ItemPostBinding) {
            item.post?.let {
                post = it
            }

            item.autor?.let {
                user = it.apply { foto = BaseNetwork.BASE_URL2 + foto }
            }

            handler = PostHandler
            executePendingBindings()
        }

    }

}