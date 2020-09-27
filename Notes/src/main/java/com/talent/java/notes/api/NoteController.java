package com.talent.java.notes.api;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/notes")
    public Note createNote(@RequestBody NoteRequest note) {
        return noteService.createNote(note.title, note.content, note.tagsId);
    }

    @GetMapping("/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/notes")
    public List<Note> findNotes() {
        return noteService.findNotes();
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody NoteRequest note) {
       return noteService.updateNote(id, note.title, note.content,note.tagsId)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
        public Set<Long> tagsId;
    }
}
