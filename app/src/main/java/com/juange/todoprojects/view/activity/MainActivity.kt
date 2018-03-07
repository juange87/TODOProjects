package com.juange.todoprojects.view.activity

import com.juange.todoprojects.R

class MainActivity : BaseActivity() {

    override fun onRequestLayout(): Int = R.layout.activity_main

    override fun onInitializeInjection() {
        component.inject(this)
    }

    override fun onViewReady() { }
}
