package com.juange.todoprojects.data

import com.juange.todoprojects.data.datasource.task.TaskLocalDataSource
import com.juange.todoprojects.data.datasource.task.TaskRemoteDataSource
import com.juange.todoprojects.data.net.task.model.mapToDomain
import com.juange.todoprojects.data.persistence.task.model.mapToDomain
import com.juange.todoprojects.data.persistence.task.model.maptToEntity
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.repository.TaskRepository
import io.reactivex.Single
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
        private val local: TaskLocalDataSource,
        private val remote: TaskRemoteDataSource) : TaskRepository {

    override fun getTasksByProject(projectId: Int): Single<List<Task>> {
        return remote.getTasksByProject(projectId)
                .map { it.mapToDomain() }
                .flatMap { storeTasks(it) }
    }

    override fun getLocalTasksByProject(projectId: Int): Single<List<Task>> {
        return local.getTasksByProject(projectId)
                .map { it.mapToDomain() }
    }

    override fun storeTasks(tasks: List<Task>): Single<List<Task>> {
        return local.storeTasks(tasks.maptToEntity())
                .map { it.mapToDomain() }
    }
}