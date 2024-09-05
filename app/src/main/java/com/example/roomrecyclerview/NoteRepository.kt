package com.example.roomrecyclerview

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class NoteRepository(application: Application) {
    private val noteDao: NoteDao

    private val allNotes: LiveData<List<Note>>
    private var database: NoteDatabase

    init {
        database = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }


    fun insert(note: Note) = runBlocking(Dispatchers.Default)
    {
        withContext(Dispatchers.Default) {
            noteDao.insert(note = note)
        }

    }

    fun update(note: Note) = runBlocking(Dispatchers.Default) {

        withContext(Dispatchers.Default)
        {
            noteDao.update(note)
        }
    }

    fun delete(note: Note) = runBlocking(Dispatchers.Default) {
        withContext(Dispatchers.Default)
        {
            noteDao.delete(note)
        }
    }

    fun deleteAllNodes() = runBlocking(Dispatchers.Default) {

        withContext(Dispatchers.Default)
        {
            noteDao.deleteAllNotes()
        }
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }


}

