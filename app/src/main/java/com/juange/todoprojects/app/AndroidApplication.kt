package com.juange.todoprojects.app

import android.app.Application
import com.juange.todoprojects.dagger.AppComponent
import com.juange.todoprojects.dagger.AppModule
import com.juange.todoprojects.dagger.DaggerAppComponent

class AndroidApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}
