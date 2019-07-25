package com.albuquerque.parrot.app.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.albuquerque.parrot.BR

class User : BaseObservable(){

        @Bindable
        var nome: String = ""
                set(value) {
                        field = value
                        notifyPropertyChanged(BR.nome)
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



}
