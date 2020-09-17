package com.jabezmagomere.core.util

import android.content.Context
import com.jabezmagomere.core.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun String.getTimeDiffFromStringTime(timeFormat: String, context: Context): String? {
    return try {
        val simpleDateFormat = SimpleDateFormat(timeFormat, Locale.getDefault())
        val oldDate = simpleDateFormat.parse(this) ?: Date()
        val currentDate = Date()
        val timeDiff = currentDate.time - oldDate.time
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeDiff)
        val hours = TimeUnit.MILLISECONDS.toHours(timeDiff)
        val days = TimeUnit.MILLISECONDS.toDays(timeDiff)
        return if (minutes < 60) {
            context.resources.getQuantityString(
                R.plurals.minutes_ago,
                minutes.toInt(),
                minutes.toInt()
            )
        } else {
            if (hours < 24) {
                context.resources.getQuantityString(
                    R.plurals.hours_ago,
                    hours.toInt(),
                    hours.toInt()
                )
            } else {
                context.resources.getQuantityString(R.plurals.days_ago, days.toInt(), days.toInt())
            }
        }
    } catch (parseException: ParseException) {
        null
    }

}