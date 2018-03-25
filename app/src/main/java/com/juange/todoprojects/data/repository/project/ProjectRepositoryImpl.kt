package com.juange.todoprojects.data.repository.project

import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSource
import com.juange.todoprojects.data.net.project.model.mapToDomain
import com.juange.todoprojects.data.persistence.room.model.mapToDomain
import com.juange.todoprojects.data.persistence.room.model.mapToEntity
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor(
        private val local: ProjectLocalDataSource,
        private val remote: ProjectRemoteDataSource
) : ProjectRepository {

    override fun getProjects(): List<Project> = storeProjects(remote.getProjects().mapToDomain())

    override fun getLocalProjects(): List<Project> = local.getProjects().mapToDomain()

    override fun storeProjects(projects: List<Project>): List<Project> =
            local.storeProjects(projects.mapToEntity()).mapToDomain()
}