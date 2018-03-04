package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSourceImpl
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSource
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSourceImpl
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
}
