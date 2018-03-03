package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.ProjectRepositoryImpl
import com.juange.todoprojects.domain.repository.ProjectRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideProjectRepository(repository: ProjectRepositoryImpl): ProjectRepository = repository
}
