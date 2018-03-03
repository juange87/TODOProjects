package com.juange.todoprojects.dagger.module

import android.support.v4.app.Fragment
import com.juange.todoprojects.domain.di.UseCaseModule
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(UseCaseModule::class))
class FragmentModule(private val fragment: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment = fragment
}
