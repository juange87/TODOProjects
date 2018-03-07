package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.persistence.task.TaskStorage
import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import io.reactivex.Single
import javax.inject.Inject

class TaskLocalDataSourceImpl @Inject constructor(private val storage: TaskStorage) : TaskLocalDataSource {

    override fun getTasksByProject(projectId: Int): Single<List<TaskRoomEntity>> = storage.getTaskByProject(projectId)

    override fun storeTasks(tasks: List<TaskRoomEntity>): Single<List<TaskRoomEntity>> = storage.storeTasks(tasks)
}