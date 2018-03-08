package com.juange.todoprojects.view.activity

import android.content.Intent
import android.support.test.espresso.intent.rule.IntentsTestRule
import com.juange.todoprojects.ScreenshotTest
import org.junit.Rule
import org.junit.Test

/**
 * Note: Mi intention here was provide mocks of the repositories thanks to DaggerMock (https://github.com/fabioCollini/DaggerMock)
 *
 * So, in that way I haven't to rely on the Network.
 *
 * This is the reason of the Thread.sleep(2000)
 *
 * Until I have time to improve this part
 */
class TasksActivityScreenShotTest : ScreenshotTest() {

    @get:Rule
    var activityRule = IntentsTestRule(TasksActivity::class.java, true, false)

    @Test
    @Throws(Exception::class)
    fun testTasksActivityLoaded() {
        val activity = startActivity()

        Thread.sleep(3000) //I'm sorry for this shit

        compareScreenshot(activity)
    }

    private fun startActivity(): TasksActivity {
        val intent = Intent()
        intent.putExtra(TasksActivity.ARG_PROJECT_ID, 301444)
        intent.putExtra(TasksActivity.ARG_PROJECT_NAME, "Test ScreenShot Prohect")
        return activityRule.launchActivity(intent)
    }
}