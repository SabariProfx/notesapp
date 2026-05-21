package com.backend.notesapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.notesapp.Entity.Notes;

public interface NotesRepository extends JpaRepository<Notes,Integer> {

}
