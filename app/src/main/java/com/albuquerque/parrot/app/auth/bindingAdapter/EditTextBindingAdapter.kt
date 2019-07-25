package com.albuquerque.parrot.app.auth.bindingAdapter

import android.text.TextUtils
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("passwordValidator", "msgError")
fun passwordValidator(view: TextInputLayout, password: String, msgError: String) {

    if (TextUtils.isEmpty(password)) {
        view.error = null
        return
    }

    if (view.editText?.text.toString().length < 3) {

        view.error = msgError

    } else {
        view.error = null
    }

}