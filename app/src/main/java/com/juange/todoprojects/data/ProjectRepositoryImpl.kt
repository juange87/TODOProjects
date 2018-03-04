package com.juange.todoprojects.data

import com.juange.todoprojects.data.datasource.ProjectLocalDataSource
import com.juange.todoprojects.data.datasource.ProjectRemoteDataSource
import com.juange.todoprojects.data.net.mapper.ProjectApiModelMapper
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import com.juange.todoprojects.data.persistence.room.model.mapper
import com.juange.todoprojects.domain.model.Project
import com.juange.todoprojects.domain.repository.ProjectRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * I hate the "Impl" in class name
 */
class ProjectRepositoryImpl @Inject constructor(
        private val local: ProjectLocalDataSource,
        private val remote: ProjectRemoteDataSource,
        private val mapper: ProjectApiModelMapper) : ProjectRepository {

    override fun getProjects(): Single<List<Project>> {
        return remote.getProjects()
                .map { mapper.mapListToDomain(it).mapper() }
                .flatMap { storeProjects(it) }
                .map { it.mapper() }
    }

    override fun getLocalProjects(): Single<List<Project>> = local.getProjects().map { it.mapper() }

    override fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>> {
        return local.storeProjects(projects)
    }
}