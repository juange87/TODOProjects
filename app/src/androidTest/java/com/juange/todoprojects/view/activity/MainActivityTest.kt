package com.juange.todoprojects.view.activity

import android.support.test.espresso.intent.rule.IntentsTestRule
import com.juange.todoprojects.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class MainActivityTest : ScreenshotTest() {

    @get:Rule
    var activityRule = IntentsTestRule(MainActivity::class.java, true, false)

    @Test
    @Throws(Exception::class)
    fun testMainActivityLoaded() {
        val activity = startActivity()

        Thread.sleep(2000) //I'm sorry for this shit

        compareScreenshot(activity)
    }

    private fun startActivity(): MainActivity = activityRule.launchActivity(null)
}