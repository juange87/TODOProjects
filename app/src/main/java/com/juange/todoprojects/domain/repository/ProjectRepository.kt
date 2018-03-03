package com.juange.todoprojects.domain.repository

import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single

interface ProjectRepository {
    fun getProjects(): Single<List<Project>>
}