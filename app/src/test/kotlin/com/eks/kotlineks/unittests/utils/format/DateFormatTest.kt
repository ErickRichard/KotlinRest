package com.eks.kotlineks.unittests.utils.format

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateFormatTest {

    companion object {

        fun formatDateObject(date: Date): Date {
            val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return formatter.parse(formatter.format(date))
        }

        fun createIniDateTest(): Date {
            val date = "2022-01-01 00:00:00"
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return format.parse(date)
        }

        fun createEndDateTest(): Date {
            val date = "2022-12-01 23:00:00"
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return format.parse(date)
        }

        private fun createDateFormat(): DateFormat {
            return SimpleDateFormat("yyyy/MM/dd")
        }

        fun formatDateList(data: String): String {
            val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            val date: Date = formatter.parse(data)
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return sdf.format(date)
        }

        fun formatDateListN(data: String): String {
            val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
            val date: Date = formatter.parse(data)
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return sdf.format(date)
        }

        fun createDateFormatedTest(date: String): Date {
            val format = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return format.parse(date)
        }
    }
}