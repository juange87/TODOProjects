package com.juange.todoprojects.domain.repository

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single

interface ProjectRepository {
    fun getProjects(): Single<List<Project>>
    fun getLocalProjects(): Single<List<Project>>
    fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>>
}