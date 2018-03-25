package com.juange.todoprojects.domain.project.repository

import com.juange.todoprojects.domain.project.model.Project

interface ProjectRepository {
    fun getProjects(): List<Project>
    fun getLocalProjects(): List<Project>
    fun storeProjects(projects: List<Project>): List<Project>
}