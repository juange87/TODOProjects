package com.juange.todoprojects.view.adapter.project

import android.support.v7.util.DiffUtil
import com.juange.todoprojects.domain.project.model.Project

class ProjectDiffUtilCallback(
        private val oldProjects: List<Project>,
        private val newProjects: List<Project>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldProjects.size

    override fun getNewListSize(): Int = newProjects.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProject = oldProjects[oldItemPosition]
        val newProject = newProjects[newItemPosition]
        return oldProject.id == newProject.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProject = oldProjects[oldItemPosition]
        val newProject = newProjects[newItemPosition]
        return oldProject == newProject
    }
}