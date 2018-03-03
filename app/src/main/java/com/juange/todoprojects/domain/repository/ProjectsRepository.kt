package com.juange.todoprojects.domain.repository

import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single

interface ProjectsRepository {
    fun getProjects(): Single<List<Project>>
}