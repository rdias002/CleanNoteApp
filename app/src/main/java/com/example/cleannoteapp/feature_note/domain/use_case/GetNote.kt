package com.example.cleannoteapp.feature_note.domain.use_case

import com.example.cleannoteapp.feature_note.domain.model.Note
import com.example.cleannoteapp.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
){
    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNoteById(noteId)
    }
}