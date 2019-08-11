package com.albuquerque.parrot.app.user.viewmodel

import com.albuquerque.parrot.core.viewmodel.BaseViewModel

class ProfileViewModel(val id: Int): BaseViewModel() {

    val user = database.userDAO().get(id)

    val posts = database.postsDAO().getAll(id)

}