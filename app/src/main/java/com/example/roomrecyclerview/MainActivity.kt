package com.example.roomrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.*

class MainActivity : AppCompatActivity() {
    private var noteViewModel: NoteViewModel? = null
    lateinit var database: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = NoteDatabase.getInstance(this)
        runBlocking(Dispatchers.Default) {
            val db = database.noteDao()
            db.insert(Note(1, "Title 1", "Description 1", 1,Date(),0))
            db.insert(Note(2, "Title 2", "Description 2", 2,Date(),1))
        }
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        noteViewModel?.init(this.application)
        noteViewModel?.getAllNodes()?.observe(this) {

            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG)

        }
    }
}

/**
 *
 * What is database migrations ?
 * Let's say we make changes in our database and we sent a new update of our app with new database. So the user should get the
 * updated version of the database and should adopt it. And we have to take care, that our data is migrated and no data
 * is also not lost while doing it.
 *
 *
 */