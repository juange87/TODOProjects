package com.juange.todoprojects.domain.task.usecase

import com.juange.todoprojects.domain.base.BaseUseCase
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.repository.TaskRepository
import javax.inject.Inject

class GetTasksUseCase2 @Inject constructor(private val repository: TaskRepository) : BaseUseCase() {

    suspend fun execute(projectId: Int): List<Task> {
        return asyncAwait {
            repository.getTasksByProject(projectId)
        }
    }
}