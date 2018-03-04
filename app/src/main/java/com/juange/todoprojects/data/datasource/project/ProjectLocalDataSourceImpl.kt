package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.persistence.project.ProjectStorage
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import io.reactivex.Single
import javax.inject.Inject

class ProjectLocalDataSourceImpl @Inject constructor(private val storage: ProjectStorage) : ProjectLocalDataSource {

    override fun getProjects(): Single<List<ProjectRoomEntity>> {
        return storage.getProjects()
    }

    override fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>> {
        return storage.storeProjects(projects)
    }
}