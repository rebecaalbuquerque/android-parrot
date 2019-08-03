package com.albuquerque.parrot.app.post.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.post.adapter.PostsAdapter
import com.albuquerque.parrot.app.post.viewmodel.PostsViewModel
import com.albuquerque.parrot.databinding.ActivityPostsBinding
import kotlinx.android.synthetic.main.activity_posts.*
import com.albuquerque.parrot.app.post.model.Post

class PostsActivity : AppCompatActivity() {

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var binding: ActivityPostsBinding

    private val postAdapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts)

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)

        rvPosts.adapter = postAdapter

        setupDataBinding()

        // TODO: teste
        postsViewModel.items.observe(this@PostsActivity, Observer {
            //postsViewModel.items.value = it
            it
        })

    }


    private fun setupDataBinding() {
        with(binding) {
            lifecycleOwner = this@PostsActivity // If you are using LiveData for data binding
            viewModel = postsViewModel
            executePendingBindings()
        }
    }

}
