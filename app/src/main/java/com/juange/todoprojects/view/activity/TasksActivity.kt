package com.juange.todoprojects.view.activity

import android.content.Context
import android.content.Intent
import com.juange.todoprojects.R

class TasksActivity : BaseActivity() {

    override fun onRequestLayout(): Int = R.layout.activity_tasks

    override fun onInitializeInjection() {
        component.inject(this)
    }

    override fun onViewReady() {}

    companion object {
        const val ARG_PROJECT_ID = "arg.project.id"
        const val ARG_PROJECT_NAME = "arg.project.name"

        fun getCallingIntent(context: Context, projectId: Int, projectName: String): Intent {
            val intent = Intent(context, TasksActivity::class.java)
            intent.putExtra(ARG_PROJECT_ID, projectId)
            intent.putExtra(ARG_PROJECT_NAME, projectName)
            return intent
        }
    }
}
