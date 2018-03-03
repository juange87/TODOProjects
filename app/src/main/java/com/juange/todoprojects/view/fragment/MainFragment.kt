package com.juange.todoprojects.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.dagger.component.FragmentComponent
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewReady() {
        text_view_main.text = "HOLA A TODOS"
    }
}
