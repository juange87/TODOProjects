package com.juange.todoprojects.view.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.dagger.component.FragmentComponent
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.navigation.Navigator
import com.juange.todoprojects.presentation.MainPresenter
import com.juange.todoprojects.view.adapter.project.ProjectAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseFragment(), MainPresenter.MainPresenterContractView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var navigator: Navigator

    private lateinit var adapter: ProjectAdapter

    override fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onInitView() {
        initToolbar(toolbar = toolbar)

        val layoutManager: RecyclerView.LayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager
                .VERTICAL)
        recycler.layoutManager = layoutManager
        adapter = ProjectAdapter(mutableListOf(), { navigator.navigateToTasks(activity, it.id.toInt(), it.name) })
        recycler.adapter = adapter

        swipe_refresh.setOnRefreshListener(this)
        swipe_refresh.isSoundEffectsEnabled = true
        swipe_refresh.setColorSchemeResources(R.color.green, R.color.dark_grey, R.color.cool_grey)
    }

    override fun onViewReady() {
        presenter.attachView(this)
        presenter.init()
    }

    override fun onViewDestroyed() {
        presenter.detachView()
    }

    override fun onRefresh() {
        presenter.onRefreshProjects()
    }

    override fun showErrorMessage(error: Throwable) {
        view?.let {
            Snackbar.make(it, error.message.toString(), Snackbar.LENGTH_LONG)
        }
    }

    override fun loadProjects(projects: List<Project>) {
        adapter.notifyChanges(projects)
    }

    override fun showLoading() {
        swipe_refresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh.isRefreshing = false
    }
}
