package com.juange.todoprojects.dagger.component

import com.juange.todoprojects.dagger.module.ActivityModule
import com.juange.todoprojects.dagger.module.FragmentModule
import com.juange.todoprojects.view.activity.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun plus(fragmentModule: FragmentModule): FragmentComponent
}
