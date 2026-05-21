package com.backend.notesapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    void insertNote(@RequestBody Notes note){
        service.insertNote(note);
    }

    @PutMapping("/api/notes")
    void updateNote(){
        service.updateNote();
    }
  
    void deleteNote(){
    service.deleteNote();
    }
}
