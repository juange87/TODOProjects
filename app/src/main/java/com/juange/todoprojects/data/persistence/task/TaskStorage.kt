package com.juange.todoprojects.data.persistence.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity
import io.reactivex.Single

interface TaskStorage {
    fun getTaskByProject(projectId: Int): Single<List<TaskRoomEntity>>
    fun storeTasks(tasks: List<TaskRoomEntity>): Single<List<TaskRoomEntity>>
}