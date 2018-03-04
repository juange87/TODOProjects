package com.juange.todoprojects.presentation

import android.util.Log
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.usecase.GetLocalTaskByProjectUseCase
import com.juange.todoprojects.domain.task.usecase.GetTasksUseCase
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val getProjectsUseCase: GetProjectsUseCase,
        private val getLocalProjectsUseCase: GetLocalProjectsUseCase,
        private val getLocalTaskByProjectUseCase: GetLocalTaskByProjectUseCase,
        private val getTasksUseCase: GetTasksUseCase
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

    private fun manageResult(projects: List<Project>) {
        if (projects.isEmpty()) {
            getRemoteProjects()
        }
    }

    private fun getRemoteProjects() {
        getProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<Project>>() {

            override fun onSuccess(projects: List<Project>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "REMOTE LIST: " + projects.toString())
                manageGetRemoteProjects(projects)
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "REMOTEERROR: " + e.toString())
            }
        })
    }

    private fun manageGetRemoteProjects(projects: List<Project>) {
        if (!projects.isEmpty()) {
            getLocalTasksForProject(projects[0].id.toInt())
        }
    }

    private fun getLocalTasksForProject(projectId: Int) {
        getLocalTaskByProjectUseCase.projectId = projectId
        getLocalTaskByProjectUseCase.execute(observer = object : DisposableSingleObserver<List<Task>>() {

            override fun onSuccess(tasks: List<Task>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "LOCAL TASKS LIST: " + tasks.toString())
                getRemoteTasks()
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "LOCAL ERROR TASKS: " + e.toString())
            }
        })
    }

    private fun getRemoteTasks() {
        getTasksUseCase.execute(observer = object : DisposableSingleObserver<List<Task>>() {

            override fun onSuccess(tasks: List<Task>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "REMOTE TASK LIST: " + tasks.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "REMOTE TASKS ERROR: " + e.toString())
            }
        })
    }

    override fun detachView() {
        getProjectsUseCase.disposeStreams()
        getLocalProjectsUseCase.disposeStreams()
        getLocalTaskByProjectUseCase.disposeStreams()
        getTasksUseCase.disposeStreams()
    }
}