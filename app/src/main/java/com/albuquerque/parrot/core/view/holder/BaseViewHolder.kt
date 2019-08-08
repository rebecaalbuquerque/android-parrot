package com.albuquerque.parrot.core.view.holder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.albuquerque.parrot.core.adapter.BindableView

abstract class BaseViewHolder<T>(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root), BindableView<T> {
    abstract override fun bind(item: T)
}