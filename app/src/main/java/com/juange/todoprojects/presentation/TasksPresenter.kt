package com.juange.todoprojects.presentation

import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.usecase.GetLocalTaskByProjectUseCase2
import com.juange.todoprojects.domain.task.usecase.GetTasksUseCase2
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import javax.inject.Inject

class TasksPresenter @Inject constructor(
        private val getLocalTaskByProjectUseCase2: GetLocalTaskByProjectUseCase2,
        private val getTasksUseCase2: GetTasksUseCase2
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
        launchAsyncTryCatch(
                { manageLocalResult(getLocalTaskByProjectUseCase2.execute(projectId)) },
                { ui.showErrorMessage(it) }
        )
    }

    private fun manageLocalResult(tasks: List<Task>) {
        if (!tasks.isEmpty()) {
            ui.loadTasks(tasks)
        }
        getRemoteTasks()
    }

    private fun getRemoteTasks() {
        launchAsyncTryCatch(
                { manageRemoteResult(getTasksUseCase2.execute(projectId)) },
                { ui.showErrorMessage(it) }
        )
    }

    private fun manageRemoteResult(tasks: List<Task>) {
        ui.hideLoading()
        if (!tasks.isEmpty()) {
            ui.loadTasks(tasks)
        }
    }

    fun onRefreshTasks() {
        ui.showLoading()
        getRemoteTasks()
    }

    override fun detachView() {
        cleanup()
    }
}