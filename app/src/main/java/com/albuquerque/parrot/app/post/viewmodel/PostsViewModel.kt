package com.albuquerque.parrot.app.post.viewmodel

import androidx.lifecycle.viewModelScope
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.app.auth.model.copyFrom
import com.albuquerque.parrot.core.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class PostsViewModel: BaseViewModel() {

    var user = User()

    init {
        updateUser()
    }

    fun updateUser() {
        viewModelScope.launch {
            database.userDAO().findFirst()?.let {
                user.copyFrom(it)
            }
        }
    }

}