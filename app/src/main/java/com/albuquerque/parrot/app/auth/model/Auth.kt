package com.albuquerque.parrot.app.auth.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "auth")
data class Auth(
    @PrimaryKey
    var id: Int = 0
) {

    var nome: String = ""

    var username: String = ""

    var email: String = ""

    var senha: String = ""

    var foto: String = ""

    var token: String? = null

    @Ignore
    var message: String? = null

}