package com.albuquerque.parrot.core.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.albuquerque.parrot.core.adapter.BaseAdapter
import com.albuquerque.parrot.core.holder.BaseViewHolder


@Suppress("UNCHECKED_CAST")
@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, items: List<Any>?) {

    (recyclerView.adapter as? BaseAdapter<Any, BaseViewHolder<Any>>)?.refresh(items ?: listOf())

}
