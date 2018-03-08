package com.juange.todoprojects.presentation

import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val getProjectsUseCase: GetProjectsUseCase,
        private val getLocalProjectsUseCase: GetLocalProjectsUseCase
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
        getLocalProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<Project>>() {

            override fun onSuccess(todos: List<Project>) {
                manageResult(todos)
            }

            override fun onError(error: Throwable) {
                ui.hideLoading()
                ui.showErrorMessage(error)
            }
        })
    }

    private fun manageResult(projects: List<Project>) {
        if (!projects.isEmpty()) {
            ui.loadProjects(projects)
        }
        getRemoteProjects()
    }

    private fun getRemoteProjects() {
        getProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<Project>>() {

            override fun onSuccess(projects: List<Project>) {
                manageGetRemoteProjects(projects)
            }

            override fun onError(error: Throwable) {
                ui.hideLoading()
                ui.showErrorMessage(error)
            }
        })
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
        getProjectsUseCase.disposeStreams()
        getLocalProjectsUseCase.disposeStreams()
    }
}