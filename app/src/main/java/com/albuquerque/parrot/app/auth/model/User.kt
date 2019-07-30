package com.albuquerque.parrot.app.auth.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.albuquerque.parrot.BR
import android.text.TextUtils
import android.text.Editable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

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
                        notifyPropertyChanged(BR.nome)
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
                        notifyPropertyChanged(BR.senha)
                }

        var foto: String = ""
        @Bindable get() = "http://172.18.9.240:3010/$field"


        @Ignore
        var message: String? = null

        var token: String? = null

}
