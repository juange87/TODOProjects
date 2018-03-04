package com.juange.todoprojects.data.di

import com.juange.todoprojects.data.ProjectRepositoryImpl
import com.juange.todoprojects.data.TaskRepositoryImpl
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import com.juange.todoprojects.domain.task.TaskRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideProjectRepository(repository: ProjectRepositoryImpl): ProjectRepository = repository

    @Provides
    @Singleton
    fun provideTaskRepository(repository: TaskRepositoryImpl): TaskRepository = repository
}
