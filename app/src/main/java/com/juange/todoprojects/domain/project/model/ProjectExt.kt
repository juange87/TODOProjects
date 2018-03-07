package com.juange.todoprojects.domain.project.model

import com.juange.todoprojects.util.formatDateToViewFormat

fun Project.startDateFormatted(): String = formatDateToViewFormat(this.startDate)

fun Project.endDateFormatted(): String = formatDateToViewFormat(this.endDate)

fun Project.datePeriodFormatted(): String = "${this.startDateFormatted()} - ${this.endDateFormatted()}"