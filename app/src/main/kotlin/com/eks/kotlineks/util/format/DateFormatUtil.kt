package com.eks.kotlineks.util.format

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class DateFormatUtil {

    companion object {

        fun formatDateObject(date: Date): Date {
            val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return formatter.parse(formatter.format(date))
        }

        fun formatDateList(dateList: String): String {
            val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm")
            val data = fmt.parse(dateList)
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return sdf.format(data)
        }
    }
}