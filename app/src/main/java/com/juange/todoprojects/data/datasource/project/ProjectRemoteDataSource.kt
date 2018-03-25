package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.net.project.model.ProjectApiModel

interface ProjectRemoteDataSource {
    fun getProjects(): List<ProjectApiModel>
}