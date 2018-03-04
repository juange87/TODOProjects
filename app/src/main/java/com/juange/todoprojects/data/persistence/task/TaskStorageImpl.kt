package com.juange.todoprojects.data.persistence.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomDao
import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import io.reactivex.Single
import javax.inject.Inject

class TaskStorageImpl @Inject constructor(private val dao: TaskRoomDao) : TaskStorage {

    override fun getTaskByProject(projectId: Int): Single<List<TaskRoomEntity>> {
        return Single.create({
            if (!it.isDisposed) {
                try {
                    val tasks = dao.getTasksByProject(projectId)
                    it.onSuccess(tasks)
                } catch (ex: Exception) {
                    it.onError(ex)
                }
            }
        })
    }

    override fun storeTasks(tasks: List<TaskRoomEntity>): Single<List<TaskRoomEntity>> {
        return Single.create({
            if (!it.isDisposed) {
                try {
                    val ids = dao.insertTasks(tasks)
                    if (ids.size == tasks.size) {
                        it.onSuccess(tasks)
                    } else {
                        it.onError(Exception("Error inserting tasks on Room"))
                    }
                } catch (ex: Exception) {
                    it.onError(ex)
                }
            }
        })
    }
}