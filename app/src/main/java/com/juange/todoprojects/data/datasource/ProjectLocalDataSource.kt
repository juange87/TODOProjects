package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single

interface ProjectLocalDataSource {
    fun getProjects(): Single<List<Project>>
}