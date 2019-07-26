package com.albuquerque.parrot.app.auth.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.albuquerque.parrot.BR
import android.text.TextUtils
import android.text.Editable



class User : BaseObservable(){

        /*
        * @Bindable e notifyPropertyChanged garantem que as atualizações no model atualizem também a view
        * */

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



}
