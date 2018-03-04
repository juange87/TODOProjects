package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import io.reactivex.Single

interface ProjectRemoteDataSource {
    fun getProjects(): Single<List<ProjectApiModel>>
}