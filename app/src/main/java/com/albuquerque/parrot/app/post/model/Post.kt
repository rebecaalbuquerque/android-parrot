package com.albuquerque.parrot.app.post.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.albuquerque.parrot.BR
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
class Post: BaseObservable() {

    @PrimaryKey
    var id: Int = 0

    @Bindable
    var mensagem: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.mensagem)
        }

    @Bindable
    var curtidas: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.curtidas)
        }

    @Bindable
    var curtido: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.curtido)
        }

    @SerializedName("criado_em")
    @Bindable
    var criadoEm: Long = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.criadoEm)
        }

    @Bindable
    var imagem: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.imagem)
        }

}