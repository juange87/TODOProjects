package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity

interface TaskLocalDataSource {
    fun getTasksByProject(projectId: Int): List<TaskRoomEntity>
    fun storeTasks(tasks: List<TaskRoomEntity>): List<TaskRoomEntity>
}