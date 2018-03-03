package com.juange.todoprojects.presentation

import android.util.Log
import com.juange.todoprojects.data.net.model.ProjectsItem
import com.juange.todoprojects.domain.usecase.GetProjectsUseCase
import com.juange.todoprojects.presentation.base.BasePresenter
import com.juange.todoprojects.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(private val getProjectsUseCase: GetProjectsUseCase)
    : BasePresenter<MainPresenter.MainPresenterContractView>() {

    private lateinit var ui: MainPresenterContractView

    interface MainPresenterContractView : Presenter.View {
        fun showMessage()
    }

    override fun attachView(view: MainPresenterContractView) {
        this.ui = view
    }

    override fun init() {
        ui.showMessage()

        getProjectsUseCase.execute(observer = object : DisposableSingleObserver<List<ProjectsItem>>() {

            override fun onSuccess(todos: List<ProjectsItem>) {
                // work with the resulting todos
                Log.d("TODOPROJECT", "LIST: " + todos.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("TODOPROJECT", "ERROR: " + e.toString())
            }
        })
    }

    override fun detachView() {
        getProjectsUseCase.disposeStreams()
    }
}