package com.talent.java.notes.service;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.NoteRepository;
import com.talent.java.notes.repository.TagRepository;
import com.talent.java.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Note createNote(String title, String content, Long userId) {
        User user = userRepository.findById(userId).get();
        Note note = new Note(title, content, user);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(Long id, String title, String content, Long userId) {
        User user = userRepository.findById(userId).get();
        noteRepository.update(title, content, user, id);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findNotesByTagId(Long tagId) {
        return noteRepository.findByTags_Id(tagId);
    }

}
