package com.juange.todoprojects.domain.task.usecase

import com.juange.todoprojects.domain.base.SingleUseCase
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.repository.TaskRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TaskRepository)
    : SingleUseCase<List<Task>>() {

    var projectId: Int = 0

    override fun buildUseCaseObservable(): Single<List<Task>> = repository.getTasksByProject(projectId)
}