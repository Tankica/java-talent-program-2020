package com.talent.java.notes.service;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.NoteRepository;
import com.talent.java.notes.repository.TagRepository;
import com.talent.java.notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private TagRepository tagRepository;
    private SecurityService securityService;

    @Autowired
    public NoteService(NoteRepository noteRepository, TagRepository tagRepository, SecurityService securityService) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
        this.securityService = securityService;
    }

    public Note createNote(String title, String content, Set<Long> tagsId) {

        User user = securityService.getAuthenticatedUser();
        Note note;
        if (tagsId != null && !tagsId.isEmpty()) {
            ArrayList<Tag> tags = (ArrayList<Tag>) tagRepository.findAllById(tagsId);
            note = new Note(title, content, user, tags);
        } else {
            note = new Note(title, content, user);
        }
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return noteRepository.findByUser(user);
    }

    public Note updateNote(Long id, String title, String content, Set<Long> tagsId) {
        Note note = noteRepository.findById(id).get();
        note.setTitle(title);
        note.setContent(content);
        if (tagsId != null && !tagsId.isEmpty()) {
            note.setTags(tagRepository.findAllById(tagsId));
        }
        return noteRepository.save(note);
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

