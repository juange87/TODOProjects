package com.juange.todoprojects.domain.usecase

import com.juange.todoprojects.data.net.model.ProjectsItem
import com.juange.todoprojects.domain.base.SingleUseCase
import com.juange.todoprojects.domain.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProjectsUseCase @Inject constructor(private val projectRepository: ProjectRepository)
    : SingleUseCase<List<ProjectsItem>>() {

    override fun buildUseCaseObservable(): Single<List<ProjectsItem>> {
        return projectRepository.getProjects()
    }
}