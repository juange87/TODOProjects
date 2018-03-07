package com.juange.todoprojects.domain.project.model

import junit.framework.Assert
import org.junit.Test

class ProjectTest {

    @Test
    fun testStartDateFormatted() {
        val fakeProject = Project(startDate = "20180303")
        val startDateFormatted = fakeProject.startDateFormatted()
        Assert.assertEquals("03/03/2018", startDateFormatted)
    }

    @Test
    fun testEndDateFormatted() {
        val fakeProject = Project(endDate = "20180307")
        val endDateFormatted = fakeProject.endDateFormatted()
        Assert.assertEquals("07/03/2018", endDateFormatted)
    }

    @Test
    fun testDatePeriodFormatted() {
        val fakeProject = Project(startDate = "20180303", endDate = "20180307")
        val datePeriodFormatted = fakeProject.datePeriodFormatted()
        Assert.assertEquals("03/03/2018 - 07/03/2018", datePeriodFormatted)
    }
}
