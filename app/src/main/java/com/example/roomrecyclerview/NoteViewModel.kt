package com.example.roomrecyclerview

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class NoteViewModel() : ViewModel() {
    private var repository: NoteRepository? = null
    lateinit var allNotes: LiveData<List<Note>>
    fun init(app: Application) {
        repository = NoteRepository(app)
        allNotes = repository?.getAllNotes() ?: return
    }


    fun insert(note: Note) {
        repository?.insert(note)
    }

    fun update(note: Note) {
        repository?.update(note)
    }

    fun delete(note: Note) {
        repository?.delete(note)
    }

    fun deleteAllNodes() {
        repository?.deleteAllNodes()
    }

    fun getAllNodes(): LiveData<List<Note>> {
        return allNotes
    }

}