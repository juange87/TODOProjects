package com.juange.todoprojects.view.activity

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
 */
class MainActivityScreenShotTest : ScreenshotTest() {

    @get:Rule
    var activityRule = IntentsTestRule(MainActivity::class.java, true, false)

    @Test
    @Throws(Exception::class)
    fun testMainActivityLoaded() {
        val activity = startActivity()

        Thread.sleep(2000)

        compareScreenshot(activity)
    }

    private fun startActivity(): MainActivity = activityRule.launchActivity(null)
}