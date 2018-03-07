package com.juange.todoprojects.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.juange.todoprojects.app.AndroidApplication
import com.juange.todoprojects.dagger.component.ActivityComponent
import com.juange.todoprojects.dagger.component.AppComponent
import com.juange.todoprojects.dagger.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {

    private val applicationComponent: AppComponent
        get() = (application as AndroidApplication).appComponent

    val component: ActivityComponent by lazy { applicationComponent.plus(ActivityModule(this)) }

    abstract fun onViewReady()

    abstract fun onRequestLayout(): Int

    abstract fun onInitializeInjection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(onRequestLayout())
        onInitializeInjection()
        onViewReady()
    }
}
