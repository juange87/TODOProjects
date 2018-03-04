package com.juange.todoprojects.data.datasource.task

import com.juange.todoprojects.data.net.task.model.TaskApiModel
import io.reactivex.Single
import javax.inject.Inject

class TaskLocalDataSourceImpl @Inject constructor() : TaskLocalDataSource {

    override fun getTasksByProject(projectId: String): Single<List<TaskApiModel>> {
        return Single.just(emptyList())
    }
}