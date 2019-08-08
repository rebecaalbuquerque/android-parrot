package com.albuquerque.parrot.app.post.model

import com.albuquerque.parrot.app.user.model.User
import com.albuquerque.parrot.core.network.BaseNetwork

class PostUser {

    var idPost: Int = 0

    var userId: Int = 0

    var mensagem: String = ""

    var curtidas: Int = 0

    var curtido: Boolean = false

    var criadoEm: Long = 0

    var imagem: String? = null

    var idUser: Int = 0

    var nome: String = ""

    var username: String = ""

    var email: String = ""

    var senha: String = ""

    var confirmarSenha: String = ""

    var foto: String = ""
        get() = BaseNetwork.BASE_URL2 + field

}

fun PostUser.toPost(): Post {

    return Post().apply {
        id = this@toPost.idPost
        userId = this@toPost.userId
        mensagem = this@toPost.mensagem
        curtidas = this@toPost.curtidas
        curtido = this@toPost.curtido
        criadoEm = this@toPost.criadoEm
        imagem = this@toPost.imagem
    }

}

fun PostUser.toUser(): User {

    return User().apply {
        id = this@toUser.idUser
        nome = this@toUser.nome
        username = this@toUser.username
        email = this@toUser.email
        senha = this@toUser.senha
        confirmarSenha = this@toUser.confirmarSenha
        foto = this@toUser.foto
    }

}