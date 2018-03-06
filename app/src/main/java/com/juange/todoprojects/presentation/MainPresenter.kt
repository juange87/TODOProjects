package com.juange.todoprojects.presentation

import android.util.Log
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
                Log.d("TODOPROJECT", "LOCAL LIST: " + todos.toString())

                manageResult(todos)
            }

            override fun onError(e: Throwable) {
                ui.hideLoading()
                Log.d("TODOPROJECT", "LOCALERROR: " + e.toString())
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
                Log.d("TODOPROJECT", "REMOTE LIST: " + projects.toString())
                manageGetRemoteProjects(projects)
            }

            override fun onError(e: Throwable) {
                ui.hideLoading()
                Log.d("TODOPROJECT", "REMOTEERROR: " + e.toString())
            }
        })
    }

    private fun manageGetRemoteProjects(projects: List<Project>) {
        if (!projects.isEmpty()) {
            ui.hideLoading()
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