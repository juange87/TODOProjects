package com.juange.todoprojects.data.persistence.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomDao
import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import javax.inject.Inject

class TaskStorageImpl @Inject constructor(private val dao: TaskRoomDao) : TaskStorage {

    override fun getTaskByProject(projectId: Int): List<TaskRoomEntity> {
        return dao.getTasksByProject(projectId)
    }

    override fun storeTasks(tasks: List<TaskRoomEntity>): List<TaskRoomEntity> {
        val ids = dao.insertTasks(tasks)
        return if (ids.size == tasks.size) {
            tasks
        } else {
            emptyList()
        }
    }
}