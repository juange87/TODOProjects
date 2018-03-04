package com.juange.todoprojects.data

import com.juange.todoprojects.data.datasource.project.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.project.ProjectRemoteDataSource
import com.juange.todoprojects.data.net.project.model.mapToDomain
import com.juange.todoprojects.data.persistence.room.model.mapToDomain
import com.juange.todoprojects.data.persistence.room.model.mapToEntity
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor(
        private val local: ProjectLocalDataSource,
        private val remote: ProjectRemoteDataSource) : ProjectRepository {

    override fun getProjects(): Single<List<Project>> {
        return remote.getProjects()
                .map { it.mapToDomain() }
                .flatMap { storeProjects(it) }
    }

    override fun getLocalProjects(): Single<List<Project>> = local.getProjects().map { it.mapToDomain() }

    override fun storeProjects(projects: List<Project>): Single<List<Project>> {
        return local.storeProjects(projects.mapToEntity())
                .map { it.mapToDomain() }
    }
}