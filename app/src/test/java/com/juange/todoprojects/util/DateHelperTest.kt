package com.juange.todoprojects.util

import junit.framework.Assert
import org.junit.Test

class DateHelperTest {

    @Test
    fun testFormatDateString() {
        val formatDateToViewFormat = formatDateToViewFormat("20170223")
        Assert.assertEquals("23/02/2017", formatDateToViewFormat)
    }

    @Test
    fun testFormatDateStringEmpty() {
        val formatDateToViewFormat = formatDateToViewFormat("")
        Assert.assertEquals("", formatDateToViewFormat)
    }

    @Test
    fun testFormatDateStringNull() {
        val formatDateToViewFormat = formatDateToViewFormat(null)
        Assert.assertEquals("", formatDateToViewFormat)
    }
}