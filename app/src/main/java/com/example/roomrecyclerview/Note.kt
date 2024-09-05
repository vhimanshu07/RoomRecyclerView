package com.example.roomrecyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "note_table")
data class Note(


    @PrimaryKey var id: Int,

    var title: String,

    var description: String,

    var priority: Int,

    var date: Date,

    var isActive :Int


    )