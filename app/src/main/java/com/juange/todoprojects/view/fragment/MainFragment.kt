package com.juange.todoprojects.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.dagger.component.FragmentComponent
import com.juange.todoprojects.presentation.MainPresenter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseFragment(), MainPresenter.MainPresenterContractView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun doInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewReady() {
        presenter.attachView(this)
        presenter.init()
    }

    override fun onViewDestroyed() {
        presenter.detachView()
    }

    override fun showMessage() {
        text_view_main.text = "HOLA A TODOS 2"
    }
}
