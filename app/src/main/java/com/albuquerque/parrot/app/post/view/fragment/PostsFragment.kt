package com.albuquerque.parrot.app.post.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.post.adapter.PostsAdapter
import com.albuquerque.parrot.app.post.viewmodel.PostsViewModel
import com.albuquerque.parrot.databinding.FragmentPostsBinding
import kotlinx.android.synthetic.main.fragment_posts.*

class PostsFragment : Fragment() {

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var binding: FragmentPostsBinding

    private val postAdapter = PostsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false)
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupView()
        setupDataBinding()
    }

    private fun setupDataBinding() {
        with(binding) {
            lifecycleOwner = this@PostsFragment // If you are using LiveData for data binding
            viewModel = postsViewModel
            executePendingBindings()
        }
    }

    private fun setupView() {
        rvPosts.adapter = postAdapter
    }

}
