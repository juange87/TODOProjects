package com.juange.todoprojects.dagger.component

import com.juange.todoprojects.dagger.module.FragmentModule
import com.juange.todoprojects.view.fragment.BaseFragment
import com.juange.todoprojects.view.fragment.MainFragment
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(fragment: BaseFragment)
    fun inject(fragment: MainFragment)
}
