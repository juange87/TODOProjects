package com.juange.todoprojects.dagger.module

import android.content.Context
import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.data.di.ApiModule
import com.juange.todoprojects.data.di.DataSourceModule
import com.juange.todoprojects.data.di.RepositoriesModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
        includes = arrayOf(
                RepositoriesModule::class,
                DataSourceModule::class,
                ApiModule::class
        )
)
class AppModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplication(): AndroidApplication = application

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext
}
