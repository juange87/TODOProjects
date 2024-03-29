package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import io.reactivex.Single

interface TaskLocalDataSource {
    fun getTasksByProject(projectId: Int): Single<List<TaskRoomEntity>>
    fun storeTasks(tasks: List<TaskRoomEntity>): Single<List<TaskRoomEntity>>
}