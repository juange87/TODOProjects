package com.juange.todoprojects.domain.project.repository

import com.juange.todoprojects.domain.project.model.Project
import io.reactivex.Single

interface ProjectRepository {
    fun getProjects(): Single<List<Project>>
    fun getLocalProjects(): Single<List<Project>>
    fun storeProjects(projects: List<Project>): Single<List<Project>>
}