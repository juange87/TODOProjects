package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.data.net.ProjectApi
import com.juange.todoprojects.data.net.model.ProjectsItem
import io.reactivex.Single
import javax.inject.Inject

class ProjectRemoteDataSourceImpl @Inject constructor(private val api: ProjectApi) : ProjectRemoteDataSource {

    override fun getProjects(): Single<List<ProjectsItem>> {
        return api.getProjects()
    }
}