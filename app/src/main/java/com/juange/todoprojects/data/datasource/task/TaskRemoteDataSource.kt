package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.net.task.model.TaskApiModel

interface TaskRemoteDataSource {
    fun getTasksByProject(projectId: Int): List<TaskApiModel>
}