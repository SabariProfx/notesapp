package com.backend.notesapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.notesapp.Entity.Notes;
import com.backend.notesapp.Repository.NotesRepository;

@Service
public class NoteService {

    NotesRepository repository;

    @Autowired
    public NoteService(NotesRepository repository) {
        this.repository = repository;
    }

    public List<Notes> getNotes() {
        // business logic
        return repository.findAll();
    }

    public Notes insertNote(Notes note) {
        return repository.save(note);
    }

    public Notes updateNotes(Integer id, Notes note) {
        Notes newNote = repository.findById(id).orElseThrow();
        if (!note.getContent().isBlank())
            newNote.setContent(note.getContent());
        if (!note.getTitle().isBlank())
            newNote.setTitle(note.getTitle());
        return repository.save(newNote);
    }

    public void deleteNote(Integer id) {
        repository.deleteById(id);
    }
}
