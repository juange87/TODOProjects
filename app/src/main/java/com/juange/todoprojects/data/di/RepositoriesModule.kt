package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.ProjectsRepositoryImpl
import com.juange.todoprojects.domain.repository.ProjectsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideProjectsRepository(repository: ProjectsRepositoryImpl): ProjectsRepository = repository
}
