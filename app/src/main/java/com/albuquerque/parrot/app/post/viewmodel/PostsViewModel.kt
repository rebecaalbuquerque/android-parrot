package com.albuquerque.parrot.app.post.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.albuquerque.parrot.app.post.business.PostsBusiness
import com.albuquerque.parrot.app.post.model.PostUser
import com.albuquerque.parrot.app.post.model.PostUser2
import com.albuquerque.parrot.core.session.SessionController
import com.albuquerque.parrot.core.viewmodel.BaseViewModel

class PostsViewModel : BaseViewModel() {

    var user = SessionController.user

    val items: LiveData<List<PostUser>> = /*database.postsDAO().getAll()*/ MutableLiveData()

    val items2: LiveData<List<PostUser2>> = database.postsDAO().getAll2()

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


}