package com.juange.todoprojects.view.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import com.juange.todoprojects.R
import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.dagger.component.AppComponent
import com.juange.todoprojects.dagger.component.FragmentComponent
import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.FragmentModule
import com.juange.todoprojects.view.activity.BaseActivity

abstract class BaseFragment : Fragment() {

    private lateinit var baseActivity: BaseActivity

    private val applicationComponent: AppComponent
        get() = (activity.application as AndroidApplication).appComponent

    private val fragmentComponent: FragmentComponent by lazy {
        applicationComponent.plus(ActivityModule(activity)).plus(FragmentModule(this))
    }

    abstract fun onInitView()
    abstract fun onViewReady()
    abstract fun onViewDestroyed()

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is BaseActivity) {
            this.baseActivity = context
        }
        doInjection(fragmentComponent)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onInitView()
        onViewReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onViewDestroyed()
    }

    open fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    fun initToolbar(toolbar: Toolbar, backNavigation: Boolean = false) {
        baseActivity.setSupportActionBar(toolbar)
        if (backNavigation) {
            enableBackButton()
            toolbar.setNavigationOnClickListener {  activity.onBackPressed() }
        }
        val elevation = resources.getDimensionPixelSize(R.dimen.app_bar_elevation)
        ViewCompat.setElevation(toolbar, elevation.toFloat())
    }

    private fun enableBackButton() {
        if (baseActivity.supportActionBar != null) {
            baseActivity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            baseActivity.supportActionBar!!.setHomeActionContentDescription(getString(R.string.action_back))
        }
    }
}
