package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.data.net.model.ProjectApiModel
import io.reactivex.Single

interface ProjectRemoteDataSource {
    fun getProjects(): Single<List<ProjectApiModel>>
}