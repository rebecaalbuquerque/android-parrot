package com.albuquerque.parrot.app.user.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.albuquerque.parrot.BR
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class User : BaseObservable(), IUser {

        @PrimaryKey
        var id: Int = 0

        @Bindable
        var nome: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.nome)
                }

        @Bindable
        var username: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.username)
                }

        @Bindable
        var email: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.email)
                }

        @Bindable
        var senha: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.senha)
                }

        @Bindable
        var confirmarSenha: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.confirmarSenha)
                }

        @Bindable
        var foto: String? = null
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.foto)
                }
}