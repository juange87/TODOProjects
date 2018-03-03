package com.juange.todoprojects.presentation.base

interface Presenter<in V : Presenter.View> {

    interface View

    fun attachView(view: V)

    fun init()

    fun detachView()
}
