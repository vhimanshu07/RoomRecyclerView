package com.example.roomrecyclerview

import androidx.room.TypeConverter
import java.util.*

/**
 *
 *
 * As we have limited type of data present( INTEGER,NULL,TEXT,REAL, BLOB)
 * So if we want to store another type of data then we have to convert them.
 *
 *
 */

class Convertors {


    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }
}