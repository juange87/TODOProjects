package com.juange.todoprojects.dagger.module

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment = fragment
}
