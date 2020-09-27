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

        User user = securityService.getAuthenticatedUsers();
        ArrayList<Tag> tags = (ArrayList<Tag>) tagsId.stream()
                .map(tagId -> tagRepository.findById(tagId).get())
                .collect(Collectors.toList());

        Note note = new Note(title, content, user, tags);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        User user = securityService.getAuthenticatedUsers();
        return noteRepository.findByUser(user);
    }

    public Optional<Note> updateNote(Long id, String title, String content, Set<Long> tagsId) {

        return noteRepository.findById(id).map(note -> {
            note.setTitle(title);
            note.setContent(content);
            note.setTags(tagsId.stream()
                    .map(tagId -> tagRepository.findById(tagId).get())
                    .collect(Collectors.toList()));
            noteRepository.save(note);
            return note;
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

