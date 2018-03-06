package com.juange.todoprojects.dagger.component

import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.FragmentModule
import com.juange.todoprojects.view.activity.MainActivity
import com.juange.todoprojects.view.activity.TasksActivity
import dagger.Subcomponent

@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: TasksActivity)

    fun plus(fragmentModule: FragmentModule): FragmentComponent
}
