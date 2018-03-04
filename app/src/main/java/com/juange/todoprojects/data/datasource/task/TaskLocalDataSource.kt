package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.net.task.model.TaskApiModel
import io.reactivex.Single

interface TaskLocalDataSource {
    fun getTasksByProject(projectId: String): Single<List<TaskApiModel>>
}