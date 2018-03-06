package com.juange.todoprojects.view.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.domain.task.model.Task

class TasksAdapter(private val dataSet: List<Task>) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.task_row, parent, false)
        return TaskViewHolder(v)
    }

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        val project = dataSet[position]
        holder?.bind(project)
    }

    override fun getItemCount(): Int = dataSet.size
}