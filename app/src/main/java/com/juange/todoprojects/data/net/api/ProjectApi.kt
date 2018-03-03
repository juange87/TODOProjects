package com.juange.todoprojects.data.net.api

import com.juange.todoprojects.data.net.model.ProjectApiModel
import io.reactivex.Single

interface ProjectApi {
    fun getProjects(): Single<List<ProjectApiModel>>
}