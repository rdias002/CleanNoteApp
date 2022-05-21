package com.example.cleannoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleannoteapp.feature_note.data.data_source.NoteDatabase
import com.example.cleannoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleannoteapp.feature_note.domain.repository.NoteRepository
import com.example.cleannoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDb(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases{
        return NotesUseCases(
            GetNotes(repository),
            GetNote(repository),
            AddNote(repository),
            DeleteNote(repository)
        )
    }
}