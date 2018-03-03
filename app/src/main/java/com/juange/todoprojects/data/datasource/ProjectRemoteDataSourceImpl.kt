package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.data.net.api.ProjectApi
import com.juange.todoprojects.data.net.model.ProjectApiModel
import io.reactivex.Single
import javax.inject.Inject

class ProjectRemoteDataSourceImpl @Inject constructor(private val api: ProjectApi) : ProjectRemoteDataSource {

    override fun getProjects(): Single<List<ProjectApiModel>> {
        return api.getProjects()
    }
}