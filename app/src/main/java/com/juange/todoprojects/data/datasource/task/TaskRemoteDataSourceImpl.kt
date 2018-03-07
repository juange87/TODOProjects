package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.net.task.api.TaskApi
import com.juange.todoprojects.data.net.task.model.TaskApiModel
import io.reactivex.Single
import javax.inject.Inject

class TaskRemoteDataSourceImpl @Inject constructor(private val api: TaskApi) : TaskRemoteDataSource {

    override fun getTasksByProject(projectId: Int): Single<List<TaskApiModel>> = api.getTasksByProject(projectId)
}