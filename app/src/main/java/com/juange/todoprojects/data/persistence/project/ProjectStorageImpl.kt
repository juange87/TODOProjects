package com.juange.todoprojects.data.persistence.project

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import javax.inject.Inject

class ProjectStorageImpl @Inject constructor(private val dao: ProjectRoomDao) : ProjectStorage {

    override fun getProjects(): List<ProjectRoomEntity> {
        return dao.getProjects()
    }

    override fun storeProjects(projects: List<ProjectRoomEntity>): List<ProjectRoomEntity> {
        val ids = dao.insertProjects(projects)
        return if (ids.size == projects.size) {
            projects
        } else {
            listOf()
        }
    }
}