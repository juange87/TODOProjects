package com.juange.todoprojects.dagger.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity = this.activity
}
