package com.juange.todoprojects.data

import com.juange.todoprojects.domain.model.Project
import com.juange.todoprojects.domain.repository.ProjectsRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * I hate the "Impl" in class name
 */
class ProjectsRepositoryImpl @Inject constructor() : ProjectsRepository {
    override fun getProjects(): Single<List<Project>> = Single.just(emptyList())
}