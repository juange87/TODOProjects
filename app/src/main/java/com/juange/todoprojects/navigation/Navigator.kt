package com.juange.todoprojects.navigation

import android.content.Context
import com.juange.todoprojects.view.activity.TasksActivity
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun navigateToTasks(context: Context, projectId: Int, projectName: String) {
        context.startActivity(TasksActivity.getCallingIntent(context, projectId, projectName))
    }
}