package com.example.cleannoteapp.feature_note.data.repository

import com.example.cleannoteapp.feature_note.data.data_source.NoteDao
import com.example.cleannoteapp.feature_note.domain.model.Note
import com.example.cleannoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl constructor(
    private val noteDao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> = noteDao.getNotes()

    override suspend fun getNoteById(noteId: Int): Note? = noteDao.getNoteById(noteId)

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}