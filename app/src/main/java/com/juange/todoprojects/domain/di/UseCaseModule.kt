package com.juange.todoprojects.domain.di

import com.juange.todoprojects.domain.repository.ProjectsRepository
import com.juange.todoprojects.domain.usecase.GetProjectsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UseCaseModule {

    @Provides
    @Named("getProjectsUseCase")
    internal fun provideGetProjectsUseCase(projectsRepository: ProjectsRepository): GetProjectsUseCase
            = GetProjectsUseCase(projectsRepository)
}
