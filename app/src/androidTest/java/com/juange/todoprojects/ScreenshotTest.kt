package com.juange.todoprojects

import android.app.Activity
import android.content.Context
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.filters.LargeTest
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers

@LargeTest
open class ScreenshotTest {

    protected fun compareScreenshot(activity: Activity) {
        Screenshot.snapActivity(activity).record()
    }

    protected fun compareScreenshot(holder: RecyclerView.ViewHolder, height: Int) {
        compareScreenshot(holder.itemView, height)
    }

    protected fun compareScreenshot(view: View, height: Int) {
        val context = getInstrumentation().targetContext
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        ViewHelpers.setupView(view)
                .setExactHeightPx(context.resources.getDimensionPixelSize(height))
                .setExactWidthPx(metrics.widthPixels)
                .layout()
        Screenshot.snap(view).record()
    }
}
