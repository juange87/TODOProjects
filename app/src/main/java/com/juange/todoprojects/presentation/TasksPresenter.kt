package com.juange.todoprojects.presentation

import android.util.Log
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.usecase.GetLocalTaskByProjectUseCase
import com.juange.todoprojects.domain.task.usecase.GetTasksUseCase
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class TasksPresenter @Inject constructor(
        private val getLocalTaskByProjectUseCase: GetLocalTaskByProjectUseCase,
        private val getTasksUseCase: GetTasksUseCase
) : BasePresenter<TasksPresenter.TaskPresenterContractView>() {

    private lateinit var ui: TaskPresenterContractView
    private var projectId: Int = 0

    interface TaskPresenterContractView : Presenter.View {
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: Throwable)
        fun loadTasks(tasks: List<Task>)
    }

    override fun attachView(view: TaskPresenterContractView) {
        this.ui = view
    }

    fun init(projectId: Int) {
        this.projectId = projectId
        ui.showLoading()
        getLocalTasks()
    }

    private fun getLocalTasks() {
        getLocalTaskByProjectUseCase.projectId = projectId
        getLocalTaskByProjectUseCase.execute(observer = object : DisposableSingleObserver<List<Task>>() {

            override fun onSuccess(tasks: List<Task>) {
                Log.d("TODOPROJECT", "LOCAL TASKS LIST: " + tasks.toString())
                manageLocalResult(tasks)
            }

            override fun onError(error: Throwable) {
                Log.d("TODOPROJECT", "LOCAL ERROR TASKS: " + error.toString())
                ui.hideLoading()
                ui.showErrorMessage(error)
            }
        })
    }

    private fun manageLocalResult(tasks: List<Task>) {
        if (!tasks.isEmpty()) {
            ui.loadTasks(tasks)
        }
        getRemoteTasks()
    }

    private fun getRemoteTasks() {
        getTasksUseCase.projectId = projectId
        getTasksUseCase.execute(observer = object : DisposableSingleObserver<List<Task>>() {

            override fun onSuccess(tasks: List<Task>) {
                Log.d("TODOPROJECT", "REMOTE TASK LIST: " + tasks.toString())
                manageRemoteResult(tasks)
            }

            override fun onError(error: Throwable) {
                Log.d("TODOPROJECT", "REMOTE TASKS ERROR: " + error.toString())
                ui.hideLoading()
                ui.showErrorMessage(error)
            }
        })
    }

    private fun manageRemoteResult(tasks: List<Task>) {
        if (!tasks.isEmpty()) {
            ui.hideLoading()
            ui.loadTasks(tasks)
        }
    }

    fun onRefreshTasks() {
        ui.showLoading()
        getRemoteTasks()
    }

    override fun detachView() {
        getLocalTaskByProjectUseCase.disposeStreams()
        getTasksUseCase.disposeStreams()
    }
}