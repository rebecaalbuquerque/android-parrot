package com.albuquerque.parrot.app.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.post.holder.PostViewHolder
import com.albuquerque.parrot.app.post.model.PostUser
import com.albuquerque.parrot.core.adapter.BaseAdapter
import com.albuquerque.parrot.databinding.ItemPostBinding


class PostsAdapter: BaseAdapter<PostUser, PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPostBinding>(inflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItemAt(position))
    }

}