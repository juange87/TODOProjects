package com.juange.todoprojects.dagger

import com.juange.todoprojects.app.AndroidApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: AndroidApplication)
}
