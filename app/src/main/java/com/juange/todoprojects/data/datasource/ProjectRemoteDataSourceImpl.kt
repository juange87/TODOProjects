package com.juange.todoprojects.data.datasource

import com.juange.todoprojects.domain.model.Project
import io.reactivex.Single
import javax.inject.Inject

class ProjectRemoteDataSourceImpl @Inject constructor() : ProjectRemoteDataSource {

    override fun getProjects(): Single<List<Project>> {
        return Single.just(emptyList())
    }
}