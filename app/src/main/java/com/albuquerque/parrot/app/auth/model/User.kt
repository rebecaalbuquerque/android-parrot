package com.albuquerque.parrot.app.auth.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.albuquerque.parrot.BR

@Entity(tableName = "user")
class User : BaseObservable(){

        /*
        * @Bindable e notifyPropertyChanged garantem que as atualizações no model atualizem também a view
        * */

        @PrimaryKey
        var id: Int = 0

        var nome: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.nome)
                }

        var username: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.username)
                }

        var email: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.email)
                }


        var senha: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.senha)
                }

        var confirmarSenha: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.confirmarSenha)
                }

        var foto: String = ""
                @Bindable get() = field
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.foto)
                }


        @Ignore
        var message: String? = null

        var token: String? = null

}


fun User.copyFrom(old: User) {

        this.apply {
                id = old.id
                nome = old.nome
                username = old.username
                email = old.email
                senha = old.senha
                confirmarSenha = old.confirmarSenha
                foto = old.foto
                token = old.token
        }
}