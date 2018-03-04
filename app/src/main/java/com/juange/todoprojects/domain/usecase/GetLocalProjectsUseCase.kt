package com.juange.todoprojects.domain.usecase

import com.juange.todoprojects.domain.base.SingleUseCase
import com.juange.todoprojects.domain.model.Project
import com.juange.todoprojects.domain.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

class GetLocalProjectsUseCase @Inject constructor(private val projectRepository: ProjectRepository)
    : SingleUseCase<List<Project>>() {

    override fun buildUseCaseObservable(): Single<List<Project>> {
        return projectRepository.getLocalProjects()
    }
}