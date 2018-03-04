package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.task.model.TaskApiModel
import io.reactivex.Single

interface TaskApi {
    fun getTasksByProject(projectId: String): Single<List<TaskApiModel>>
}