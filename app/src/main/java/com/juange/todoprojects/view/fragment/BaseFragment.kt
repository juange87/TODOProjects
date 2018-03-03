package com.juange.todoprojects.view.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.dagger.component.AppComponent
import com.juange.todoprojects.dagger.component.FragmentComponent
import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.FragmentModule

abstract class BaseFragment : Fragment() {

    val applicationComponent: AppComponent
        get() = (activity.application as AndroidApplication).appComponent

    val fragmentComponent: FragmentComponent by lazy {
        applicationComponent.plus(ActivityModule(activity)).plus(FragmentModule(this))
    }

    abstract fun onViewReady()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        doInjection(fragmentComponent)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onViewReady()
    }

    open fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }
}
