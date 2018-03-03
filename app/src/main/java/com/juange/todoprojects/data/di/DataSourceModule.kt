package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.datasource.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.ProjectLocalDataSourceImpl
import com.juange.todoprojects.data.datasource.ProjectRemoteDataSource
import com.juange.todoprojects.data.datasource.ProjectRemoteDataSourceImpl
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
