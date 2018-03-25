package com.juange.todoprojects.data.datasource.project

import com.juange.todoprojects.data.net.project.api.ProjectApi
import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import io.reactivex.Single
import javax.inject.Inject

class ProjectRemoteDataSourceImpl @Inject constructor(private val api: ProjectApi) : ProjectRemoteDataSource {

    override fun getProjects(): List<ProjectApiModel> = api.getProjects()
}