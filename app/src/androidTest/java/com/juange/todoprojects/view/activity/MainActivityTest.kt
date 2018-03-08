package com.juange.todoprojects.view.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.juange.todoprojects.R
import com.juange.todoprojects.view.adapter.project.ProjectViewHolder
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    @Throws(Exception::class)
    fun testMainActivityLoaded() {
        onView(withId(R.id.fragment)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testClickOnProjectLoadTasks() {
        onView(withId(R.id.fragment)).check(matches(isDisplayed()))

        onView(withId(R.id.recycler)).perform(actionOnItemAtPosition<ProjectViewHolder>(0, click()))

        intended(hasComponent(TasksActivity::class.java.name))
    }
}