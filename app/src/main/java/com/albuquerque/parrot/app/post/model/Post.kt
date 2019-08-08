package com.albuquerque.parrot.app.post.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.*
import com.albuquerque.parrot.BR
import com.albuquerque.parrot.app.user.model.User
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "posts",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("idUser"),
            childColumns = arrayOf("userId")
        )
    ]
)
class Post : BaseObservable() {

    @ColumnInfo(name = "idPost")
    @PrimaryKey
    var id: Int = 0

    var userId: Int = 0

    @Ignore
    var autor: User? = null

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