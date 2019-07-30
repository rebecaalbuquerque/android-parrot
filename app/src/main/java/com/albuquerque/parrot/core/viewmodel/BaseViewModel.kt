package com.albuquerque.parrot.core.viewmodel

import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.livedata.SingleLiveEvent

abstract class BaseViewModel: ViewModel() {

    val database = ParrotApplication.database

    val onError = SingleLiveEvent<Void>()

}