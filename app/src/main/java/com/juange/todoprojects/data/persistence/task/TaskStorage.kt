package com.juange.todoprojects.data.persistence.task

import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity

interface TaskStorage {
    fun getTaskByProject(projectId: Int): List<TaskRoomEntity>
    fun storeTasks(tasks: List<TaskRoomEntity>): List<TaskRoomEntity>
}