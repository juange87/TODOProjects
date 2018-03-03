package com.juange.todoprojects.data

import com.juange.todoprojects.data.datasource.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.ProjectRemoteDataSource
import com.juange.todoprojects.domain.model.Project
import com.juange.todoprojects.domain.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * I hate the "Impl" in class name
 */
class ProjectRepositoryImpl @Inject constructor(
        private val local: ProjectLocalDataSource,
        private val remote: ProjectRemoteDataSource) : ProjectRepository {

    override fun getProjects(): Single<List<Project>> = remote.getProjects()
}