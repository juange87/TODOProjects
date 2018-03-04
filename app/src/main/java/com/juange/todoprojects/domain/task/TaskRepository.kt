package com.juange.todoprojects.domain.task

import io.reactivex.Single

interface TaskRepository {
    fun getTasksByProject(projectId: String): Single<List<Task>>
}