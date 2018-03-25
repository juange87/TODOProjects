package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.net.project.model.ProjectApiModel

interface ProjectApi {
    fun getProjects(): List<ProjectApiModel>
}