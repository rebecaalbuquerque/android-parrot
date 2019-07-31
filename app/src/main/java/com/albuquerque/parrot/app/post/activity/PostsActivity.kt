package com.albuquerque.parrot.app.post.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.auth.viewmodel.AuthViewModel
import com.albuquerque.parrot.app.post.viewmodel.PostsViewModel
import com.albuquerque.parrot.databinding.ActivityPostsBinding

class PostsActivity : AppCompatActivity() {

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var binding: ActivityPostsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts)

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)

        setupDataBinding()

    }

    private fun setupDataBinding() {
        with(binding) {
            lifecycleOwner = this@PostsActivity
            viewModel = postsViewModel
            executePendingBindings()
        }
    }
}
