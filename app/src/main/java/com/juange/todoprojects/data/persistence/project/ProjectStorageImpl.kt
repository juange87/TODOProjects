package com.juange.todoprojects.data.persistence.project

import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import io.reactivex.Single
import javax.inject.Inject

class ProjectStorageImpl @Inject constructor(private val dao: ProjectRoomDao) : ProjectStorage {

    override fun getProjects(): Single<List<ProjectRoomEntity>> {
        return Single.create({
            if (!it.isDisposed) {
                try {
                    val projects = dao.getProjects()
                    it.onSuccess(projects)
                } catch (ex: Exception) {
                    it.onError(ex)
                }
            }
        })
    }

    override fun storeProjects(projects: List<ProjectRoomEntity>): Single<List<ProjectRoomEntity>> {
        return Single.create({
            if (!it.isDisposed) {
                try {
                    val ids = dao.insertProjects(projects)
                    if (ids.size == projects.size) {
                        it.onSuccess(projects)
                    } else {
                        it.onError(Exception("Error inserting projects on Room"))
                    }
                } catch (ex: Exception) {
                    it.onError(ex)
                }
            }
        })
    }
}