package com.juange.todoprojects.domain.di

import com.juange.todoprojects.domain.repository.ProjectRepository
import com.juange.todoprojects.domain.usecase.GetProjectsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UseCaseModule {

    @Provides
    @Named("getProjectsUseCase")
    internal fun provideGetProjectsUseCase(projectRepository: ProjectRepository): GetProjectsUseCase
            = GetProjectsUseCase(projectRepository)
}
