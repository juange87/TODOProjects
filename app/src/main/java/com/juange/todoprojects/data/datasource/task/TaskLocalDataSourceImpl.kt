package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.persistence.task.TaskStorage
import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import javax.inject.Inject

class TaskLocalDataSourceImpl @Inject constructor(private val storage: TaskStorage) : TaskLocalDataSource {

    override fun getTasksByProject(projectId: Int): List<TaskRoomEntity> = storage.getTaskByProject(projectId)

    override fun storeTasks(tasks: List<TaskRoomEntity>): List<TaskRoomEntity> = storage.storeTasks(tasks)
}