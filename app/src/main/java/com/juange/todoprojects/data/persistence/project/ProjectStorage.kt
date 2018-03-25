package com.juange.todoprojects.data.persistence.project

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity

interface ProjectStorage {
    fun getProjects(): List<ProjectRoomEntity>
    fun storeProjects(projects: List<ProjectRoomEntity>): List<ProjectRoomEntity>
}