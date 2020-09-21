package com.talent.java.noteswithoutdatabase.repository;

import com.talent.java.noteswithoutdatabase.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {

    private long incrementId = 1;
    private ArrayList<Note> notes = new ArrayList<>();

    public void save(Note note) {
        note.setId(incrementId++);
        notes.add(note);
    }

    public List<Note> findAll() {
        return notes;
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public void update(Note newNote, Long id) {
        findById(id).ifPresent(note -> {
                    note.setTitle(newNote.getTitle());
                    note.setContent(newNote.getContent());
                });
    }

    public void delete(Long id) {
        findById(id).ifPresent(note -> notes.remove(note));
    }
}
