package com.talent.java.notes.service;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.NoteRepository;
import com.talent.java.notes.repository.UserRepository;
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

    public Note createNote(String title, String content, User user) {
        Note note = new Note(title, content, user);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public void updateNote(Long id, String title, String content) {
        noteRepository.findById(id).ifPresent(note -> {
            note.setTitle(title);
            note.setContent(content);
            noteRepository.save(note);
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

