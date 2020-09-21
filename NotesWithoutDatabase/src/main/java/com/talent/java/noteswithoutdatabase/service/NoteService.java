package com.talent.java.noteswithoutdatabase.service;

import com.talent.java.noteswithoutdatabase.model.Note;
import com.talent.java.noteswithoutdatabase.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(String title, String content){
        Note note = new Note(title, content);
        noteRepository.save(note);
    }

    public List<Note> findNotes(){
        return noteRepository.findAll();
    }

    public Optional<Note> findNote(Long id){
        return noteRepository.findById(id);
    }

    public void updateNote(String title, String content, Long id){
        Note note = new Note(title, content);
        noteRepository.update(note,id);
    }

    public void deleteNote(Long id){
        noteRepository.delete(id);
    }
}
