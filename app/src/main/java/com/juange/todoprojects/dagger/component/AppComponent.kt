package com.juange.todoprojects.dagger.component

import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.AppModule
import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSource
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: AndroidApplication)

    abstract fun projectsRepository(): ProjectRepository
    abstract fun projectLocalDataSource(): ProjectLocalDataSource
    abstract fun projectRemoteDataSource(): ProjectRemoteDataSource

    fun plus(activityModule: ActivityModule): ActivityComponent
}
