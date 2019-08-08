package com.albuquerque.parrot.app.post.view.handler

import android.view.View
import com.albuquerque.parrot.app.user.model.User
import com.albuquerque.parrot.app.user.view.activity.ProfileActivity
import com.albuquerque.parrot.app.user.view.activity.ProfileActivity.Companion.PROFILE_USER_ID
import org.jetbrains.anko.startActivity

object PostHandler {

    fun onUserPostClick(view: View, user: User) {
        view.context.startActivity<ProfileActivity>(PROFILE_USER_ID to user.id)
    }

}