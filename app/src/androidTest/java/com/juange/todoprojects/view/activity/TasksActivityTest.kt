package com.juange.todoprojects.view.activity

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.juange.todoprojects.R
import com.juange.todoprojects.ScreenshotTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TasksActivityTest : ScreenshotTest() {

    @get:Rule
    var activityRule = ActivityTestRule(TasksActivity::class.java, true, false)

    @Test
    @Throws(Exception::class)
    fun testTasksActivityLoaded() {
        startActivity()

        onView(withId(R.id.fragment)).check(matches(isDisplayed()))
    }

    private fun startActivity(): TasksActivity {
        val intent = Intent()
        intent.putExtra(TasksActivity.ARG_PROJECT_ID, 301444)
        intent.putExtra(TasksActivity.ARG_PROJECT_NAME, "Test ScreenShot Prohect")
        return activityRule.launchActivity(intent)
    }
}