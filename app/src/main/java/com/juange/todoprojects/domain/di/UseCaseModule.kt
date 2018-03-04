package com.juange.todoprojects.domain.di

import com.juange.todoprojects.domain.project.repository.ProjectRepository
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UseCaseModule {

    @Provides
    @Named("getProjectsUseCase")
    internal fun provideGetProjectsUseCase(projectRepository: ProjectRepository): GetProjectsUseCase
            = GetProjectsUseCase(projectRepository)

    @Provides
    @Named("getLocalProjectsUseCase")
    internal fun provideGetLocalProjectsUseCase(projectRepository: ProjectRepository): GetLocalProjectsUseCase
            = GetLocalProjectsUseCase(projectRepository)
}
