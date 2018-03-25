package com.juange.todoprojects.domain.task.repository

import com.juange.todoprojects.domain.task.model.Task

interface TaskRepository {
    fun getTasksByProject(projectId: Int): List<Task>
    fun getLocalTasksByProject(projectId: Int): List<Task>
    fun storeTasks(tasks: List<Task>): List<Task>
}