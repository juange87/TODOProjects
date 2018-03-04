package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSourceImpl
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSource
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSourceImpl
import com.juange.todoprojects.data.datasource.task.TaskLocalDataSource
import com.juange.todoprojects.data.datasource.task.TaskLocalDataSourceImpl
import com.juange.todoprojects.data.datasource.task.TaskRemoteDataSource
import com.juange.todoprojects.data.datasource.task.TaskRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideProjectLocalDataSource(local: ProjectLocalDataSourceImpl): ProjectLocalDataSource = local

    @Provides
    @Singleton
    fun provideProjectRemoteDataSource(remote: ProjectRemoteDataSourceImpl): ProjectRemoteDataSource = remote

    @Provides
    @Singleton
    fun provideTaskLocalDataSource(local: TaskLocalDataSourceImpl): TaskLocalDataSource = local

    @Provides
    @Singleton
    fun provideTaskRemoteDataSource(remote: TaskRemoteDataSourceImpl): TaskRemoteDataSource = remote
}
