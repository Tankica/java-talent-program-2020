package com.talent.java.notes.service;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.NoteRepository;
import com.talent.java.notes.repository.UserRepository;
import com.talent.java.notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Note note = new Note(title, content, user);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public void updateNote(Long id, String title, String content, Long userId) {
        System.out.println("TEST " + id+ " "+ title+ " "+ content+ " "+ userId+ " ");
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        noteRepository.findById(id).ifPresent(note1 -> {
            note1.setTitle(title);
            note1.setContent(content);
            note1.setUser(user);
            noteRepository.save(note1);
        });
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findNotesByTagId(Long tagId) {
        return noteRepository.findByTags_Id(tagId);
    }

    public void deleteTagsFromNotes(Tag tag) {
        noteRepository.findAll().forEach(note -> note.getTags().remove(tag));
    }
}

