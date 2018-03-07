package com.juange.todoprojects.view.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.dagger.component.FragmentComponent
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.presentation.TasksPresenter
import com.juange.todoprojects.view.activity.TasksActivity.Companion.ARG_PROJECT_ID
import com.juange.todoprojects.view.activity.TasksActivity.Companion.ARG_PROJECT_NAME
import com.juange.todoprojects.view.adapter.TasksAdapter
import kotlinx.android.synthetic.main.fragment_task.*
import javax.inject.Inject

class TaskFragment : BaseFragment(), TasksPresenter.TaskPresenterContractView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: TasksPresenter

    private lateinit var adapter: TasksAdapter

    override fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_task, container, false)

    override fun onInitView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager
        adapter = TasksAdapter(mutableListOf())
        recycler.adapter = adapter

        swipe_refresh.setOnRefreshListener(this)
        swipe_refresh.isSoundEffectsEnabled = true
        swipe_refresh.setColorSchemeResources(R.color.green, R.color.dark_grey, R.color.cool_grey)
    }

    override fun onViewReady() {
        presenter.attachView(this)

        val extras = activity.intent.extras
        extras?.let {
            val projectId = extras.getInt(ARG_PROJECT_ID, 0)
            val projectName = extras.getString(ARG_PROJECT_NAME)

            initToolbar(toolbar = toolbar, title = projectName, backNavigation = true)

            presenter.init(projectId)
        }
    }

    override fun onViewDestroyed() {
        presenter.detachView()
    }

    override fun onRefresh() {
        presenter.onRefreshTasks()
    }

    override fun showErrorMessage(error: Throwable) {
        view?.let {
            Snackbar.make(it, error.message.toString(), Snackbar.LENGTH_LONG)
        }
    }

    override fun showLoading() {
        swipe_refresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh.isRefreshing = false
    }

    override fun loadTasks(tasks: List<Task>) {
        adapter.notifyChanges(tasks)
    }
}
