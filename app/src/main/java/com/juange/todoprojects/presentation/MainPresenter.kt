package com.juange.todoprojects.presentation

import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase2
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase2
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val getProjectsUseCase2: GetProjectsUseCase2,
        private val getLocalProjectsUseCase2: GetLocalProjectsUseCase2
) : BasePresenter<MainPresenter.MainPresenterContractView>() {

    private lateinit var ui: MainPresenterContractView

    interface MainPresenterContractView : Presenter.View {
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: Throwable)
        fun loadProjects(projects: List<Project>)
    }

    override fun attachView(view: MainPresenterContractView) {
        this.ui = view
    }

    fun init() {
        ui.showLoading()
        getLocalProjects()
    }

    private fun getLocalProjects() {
        launchAsyncTryCatch(
                { manageResult(getLocalProjectsUseCase2.execute()) },
                { ui.showErrorMessage(it) }
        )
    }

    private fun manageResult(projects: List<Project>) {
        if (!projects.isEmpty()) {
            ui.loadProjects(projects)
        }
        getRemoteProjects()
    }

    private fun getRemoteProjects() {
        launchAsyncTryCatch(
                { manageGetRemoteProjects(getProjectsUseCase2.execute()) },
                { ui.showErrorMessage(it) }
        )
    }

    private fun manageGetRemoteProjects(projects: List<Project>) {
        ui.hideLoading()
        if (!projects.isEmpty()) {
            ui.loadProjects(projects)
        }
    }

    fun onRefreshProjects() {
        ui.showLoading()
        getRemoteProjects()
    }

    override fun detachView() {
        cleanup()
    }
}