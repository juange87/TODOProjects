package com.juange.todoprojects.domain.project.usecase

import com.juange.todoprojects.domain.base.SingleUseCase
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

class GetLocalProjectsUseCase @Inject constructor(private val repository: ProjectRepository)
    : SingleUseCase<List<Project>>() {

    override fun buildUseCaseObservable(): Single<List<Project>> = repository.getLocalProjects()
}