package com.juange.todoprojects.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.domain.project.model.Project

class ProjectAdapter(private val dataSet: List<Project>, private val onClick: (project: Project) -> Unit) : RecyclerView
.Adapter<ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProjectViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.project_row, parent, false)
        return ProjectViewHolder(v, onClick)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder?, position: Int) {
        val project = dataSet[position]
        holder?.bind(project)
    }

    override fun getItemCount(): Int = dataSet.size
}