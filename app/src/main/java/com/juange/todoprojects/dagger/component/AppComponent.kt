package com.juange.todoprojects.dagger.component

import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: AndroidApplication)

    fun plus(activityModule: ActivityModule): ActivityComponent
}
