package com.juange.todoprojects.domain.task.repository

import com.juange.todoprojects.domain.task.model.Task
import io.reactivex.Single

interface TaskRepository {
    fun getTasksByProject(projectId: Int): Single<List<Task>>
    fun getLocalTasksByProject(projectId: Int): Single<List<Task>>
    fun storeTasks(tasks: List<Task>): Single<List<Task>>
}