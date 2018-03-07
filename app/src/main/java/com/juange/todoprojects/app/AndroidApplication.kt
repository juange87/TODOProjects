package com.juange.todoprojects.app

import android.app.Application
import com.juange.todoprojects.dagger.component.AppComponent
import com.juange.todoprojects.dagger.component.DaggerAppComponent
import com.juange.todoprojects.dagger.module.AppModule

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
