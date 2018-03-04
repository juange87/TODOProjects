package com.juange.todoprojects.domain.task

import io.reactivex.Single

interface TaskRepository {
    fun getTasksByProject(projectId: Int): Single<List<Task>>
    fun storeTasks(tasks: List<Task>): Single<List<Task>>
}