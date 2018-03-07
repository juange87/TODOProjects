package com.juange.todoprojects.domain.task.model

import com.juange.todoprojects.util.formatDateToViewFormat

fun Task.dueDateFormatted(): String = formatDateToViewFormat(this.dueDate)
