package com.juange.todoprojects.data.net

import com.juange.todoprojects.data.net.model.ProjectsItem
import io.reactivex.Single

interface ProjectApi {
    fun getProjects(): Single<List<ProjectsItem>>
}