package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import io.reactivex.Single

interface ProjectLocalDataSource {
    fun getProjects(): Single<List<ProjectRoomEntity>>
    fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>>
}