package com.juange.todoprojects.view.adapter.task

import android.support.v7.util.DiffUtil
import com.juange.todoprojects.domain.task.model.Task

class TaskDiffUtilCallback(
        private val oldTasks: List<Task>,
        private val newTasks: List<Task>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldTasks.size

    override fun getNewListSize(): Int = newTasks.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldTask = oldTasks[oldItemPosition]
        val newTask = newTasks[newItemPosition]
        return oldTask.id == newTask.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldTask = oldTasks[oldItemPosition]
        val newTask = newTasks[newItemPosition]
        return oldTask == newTask
    }
}