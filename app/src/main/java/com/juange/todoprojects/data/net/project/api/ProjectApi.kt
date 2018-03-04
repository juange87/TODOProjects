package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import io.reactivex.Single

interface ProjectApi {
    fun getProjects(): Single<List<ProjectApiModel>>
}