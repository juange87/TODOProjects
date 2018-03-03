package com.juange.todoprojects.dagger.module

import android.content.Context
import com.juange.todoprojects.app.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplication(): AndroidApplication = application

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext
}
