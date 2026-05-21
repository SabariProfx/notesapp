package com.backend.notesapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.notesapp.Entity.Notes;
import com.backend.notesapp.Service.NoteService;

@RestController
public class Controller {

    NoteService service;

    @Autowired
    public Controller(NoteService service) {
        this.service = service;
    }

    @GetMapping("/api/notes")
    List<Notes> getNotes() {
        return service.getNotes();
    }

    @PostMapping("/api/notes")
    void insertNote(@RequestBody Notes note) {
        service.insertNote(note);
    }

    @PutMapping("/api/notes/{id}")
    void updateNote(@PathVariable Integer id, @RequestBody Notes note) {
        service.updateNotes(id, note);
    }

    @DeleteMapping("api/notes/{id}")
    void deleteNote(@PathVariable Integer id) {
        service.deleteNote(id);
    }
}
