package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity

interface ProjectLocalDataSource {
    fun getProjects(): List<ProjectRoomEntity>
    fun storeProjects(projects: List<ProjectRoomEntity>): List<ProjectRoomEntity>
}