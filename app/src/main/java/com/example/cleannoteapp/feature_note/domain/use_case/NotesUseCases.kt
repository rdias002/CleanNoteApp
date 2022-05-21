package com.example.cleannoteapp.feature_note.domain.use_case

data class NotesUseCases(
    val getNotes: GetNotes,
    val getNote: GetNote,
    val addNote: AddNote,
    val deleteNote: DeleteNote
)
