package com.juange.todoprojects.data.persistence

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import io.reactivex.Single

interface ProjectStorage {
    fun getProjects(): Single<List<ProjectRoomEntity>>
    fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>>
}