package com.juange.todoprojects.data

import com.juange.todoprojects.data.datasource.task.TaskLocalDataSource
import com.juange.todoprojects.data.datasource.task.TaskRemoteDataSource
import com.juange.todoprojects.data.net.task.model.mapToDomain
import com.juange.todoprojects.domain.task.Task
import com.juange.todoprojects.domain.task.TaskRepository
import io.reactivex.Single
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
        private val local: TaskLocalDataSource,
        private val remote: TaskRemoteDataSource) : TaskRepository {

    override fun getTasksByProject(projectId: String): Single<List<Task>> {
        return remote.getTasksByProject(projectId)
                .map { it.mapToDomain() }
    }
}