package com.juange.todoprojects.domain.project.usecase

import com.juange.todoprojects.domain.base.BaseUseCase
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import javax.inject.Inject

class GetLocalProjectsUseCase2 @Inject constructor(private val repository: ProjectRepository) : BaseUseCase() {

    suspend fun execute(): List<Project> {
        return asyncAwait {
            repository.getLocalProjects()
        }
    }
}