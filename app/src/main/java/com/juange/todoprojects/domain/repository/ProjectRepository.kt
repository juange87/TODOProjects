package com.juange.todoprojects.domain.repository

import com.juange.todoprojects.data.net.model.ProjectsItem
import io.reactivex.Single

interface ProjectRepository {
    fun getProjects(): Single<List<ProjectsItem>>
}