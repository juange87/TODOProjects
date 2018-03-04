package com.juange.todoprojects.domain.di

import com.juange.todoprojects.domain.project.repository.ProjectRepository
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase
import com.juange.todoprojects.domain.task.repository.TaskRepository
import com.juange.todoprojects.domain.task.usecase.GetLocalTaskByProjectUseCase
import com.juange.todoprojects.domain.task.usecase.GetTasksUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    internal fun provideGetProjectsUseCase(repository: ProjectRepository): GetProjectsUseCase
            = GetProjectsUseCase(repository)

    @Provides
    internal fun provideGetLocalProjectsUseCase(repository: ProjectRepository): GetLocalProjectsUseCase
            = GetLocalProjectsUseCase(repository)

    @Provides
    internal fun provideGetLocalTaskByProjectUseCase(repository: TaskRepository): GetLocalTaskByProjectUseCase
            = GetLocalTaskByProjectUseCase(repository)

    @Provides
    internal fun provideGetTasksUseCase(repository: TaskRepository): GetTasksUseCase
            = GetTasksUseCase(repository)
}
