package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single
import javax.inject.Inject

class ProjectLocalDataSourceImpl @Inject constructor() : ProjectLocalDataSource {

    override fun getProjects(): Single<List<Project>> {
        return Single.just(emptyList())
    }
}