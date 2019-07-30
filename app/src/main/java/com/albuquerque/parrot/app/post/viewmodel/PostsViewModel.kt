package com.albuquerque.parrot.app.post.viewmodel

import androidx.lifecycle.viewModelScope
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class PostsViewModel: BaseViewModel() {

    lateinit var user: User

    init {
        viewModelScope.launch {
            database.userDAO().findFirst()?.let {
                user = it
            }
        }
    }

}