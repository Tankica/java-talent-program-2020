package com.talent.java.notes.api;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.User;
import com.talent.java.notes.security.SecurityService;
import com.talent.java.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    private NoteService noteService;
    private SecurityService securityService;

    @Autowired
    public NoteController(NoteService noteService, SecurityService securityService) {
        this.noteService = noteService;
        this.securityService = securityService;
    }


    @PostMapping("/notes")
    public Note createNote(@RequestBody NoteRequest note) {
        User user = securityService.getAuthenticatedUsers();
        return noteService.createNote(note.title, note.content, user);
    }

    @GetMapping("/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/notes")
    public List<Note> findNotes() {
        User user = securityService.getAuthenticatedUsers();
        return noteService.findNotes(user);
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody NoteRequest note) {
        noteService.updateNote(id, note.title, note.content);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    @GetMapping("/tags/{tagId}/notes")
    public List<Note> findNotesByTagId(@PathVariable Long tagId) {
        return noteService.findNotesByTagId(tagId);
    }

    public static class NoteRequest {
        public String title;
        public String content;
    }
}
