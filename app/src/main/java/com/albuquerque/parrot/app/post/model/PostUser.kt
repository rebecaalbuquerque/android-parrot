package com.albuquerque.parrot.app.post.model

import androidx.room.Embedded
import com.albuquerque.parrot.app.user.model.User

class PostUser {

    @Embedded
    var post: Post? = null

    @Embedded
    var autor: User? = null

}