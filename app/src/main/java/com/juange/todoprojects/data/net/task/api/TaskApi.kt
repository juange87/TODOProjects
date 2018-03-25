package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.task.model.TaskApiModel

interface TaskApi {
    fun getTasksByProject(projectId: Int): List<TaskApiModel>
}