package com.albuquerque.parrot.app.post.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.albuquerque.parrot.app.post.business.PostsBusiness
import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.session.SessionController
import com.albuquerque.parrot.core.viewmodel.BaseViewModel

class PostsViewModel : BaseViewModel() {

    var user = SessionController.user

    val items: LiveData<List<Post>> = database.postsDAO().getAll()

    init {
        getPosts()
    }

    private fun getPosts() {
        PostsBusiness.getPostsFromAPI(
            { },
            {
                onError.call()
            }
        )
    }

    fun handleUserClick(recyclerView: View) {
        recyclerView
    }

}