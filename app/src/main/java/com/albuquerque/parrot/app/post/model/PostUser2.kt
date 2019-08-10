package com.albuquerque.parrot.app.post.model

import androidx.room.Embedded
import com.albuquerque.parrot.app.user.model.User

class PostUser2 {

    @Embedded(prefix = "post_")
    var post = Post()

    @Embedded(prefix = "autor_")
    var autor = User()
}