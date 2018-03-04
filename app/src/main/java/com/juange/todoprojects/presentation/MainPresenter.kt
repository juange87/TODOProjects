package com.juange.todoprojects.presentation

import android.util.Log
import com.juange.todoprojects.domain.model.Project
import com.juange.todoprojects.domain.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.usecase.GetProjectsUseCase
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
        fun showMessage()
    }

    override fun attachView(view: MainPresenterContractView) {
        this.ui = view
    }

    override fun init() {
        ui.showMessage()

        getLocalProjects()
    }

    private fun getLocalProjects() {
        getLocalProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<Project>>() {

            override fun onSuccess(todos: List<Project>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "LOCAL LIST: " + todos.toString())

                manageResult(todos)
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "LOCALERROR: " + e.toString())
            }
        })
    }

    private fun manageResult(todos: List<Project>) {
        if (todos.isEmpty()) {
            getRemoteProjects()
        }
    }

    private fun getRemoteProjects() {
        getProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<Project>>() {

            override fun onSuccess(todos: List<Project>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "REMOTE LIST: " + todos.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "REMOTEERROR: " + e.toString())
            }
        })
    }

    override fun detachView() {
        getProjectsUseCase.disposeStreams()
        getLocalProjectsUseCase.disposeStreams()
    }
}