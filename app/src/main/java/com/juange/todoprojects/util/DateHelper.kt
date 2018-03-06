package com.juange.todoprojects.util

import java.text.DateFormat
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    const val DF_SIMPLE_STRING_API = "yyyyMMdd"
    const val DF_SIMPLE_STRING_VIEW = "dd/MM/yyyy"

    @JvmField
    val DF_SIMPLE_FORMAT_API = object : ThreadLocal<DateFormat>() {
        override fun initialValue(): DateFormat {
            return SimpleDateFormat(DF_SIMPLE_STRING_API, Locale.getDefault())
        }
    }

    @JvmField
    val DF_SIMPLE_FORMAT_VIEW = object : ThreadLocal<DateFormat>() {
        override fun initialValue(): DateFormat {
            return SimpleDateFormat(DF_SIMPLE_STRING_VIEW, Locale.getDefault())
        }
    }
}

fun formatDateToViewFormat(dateString: String): String {
    val date = DateHelper.DF_SIMPLE_FORMAT_API.get().parse(dateString, ParsePosition(0))
    return date?.let { DateHelper.DF_SIMPLE_FORMAT_VIEW.get().format(date) } ?: ""
}