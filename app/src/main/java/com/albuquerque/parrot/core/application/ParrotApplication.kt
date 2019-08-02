package com.albuquerque.parrot.core.application

import android.app.Application
import androidx.room.Room
import com.albuquerque.parrot.core.database.AppDataBase
import com.albuquerque.parrot.core.session.SessionController
import com.facebook.stetho.Stetho
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ParrotApplication: Application() {

    companion object {
        lateinit var database: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        // Room
        database = Room.databaseBuilder(this, AppDataBase::class.java, "parrot-db").fallbackToDestructiveMigration().build()

        // Stetho
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)

        GlobalScope.launch(Dispatchers.IO) {
            SessionController.user = database.userDAO().get()
        }

    }

}