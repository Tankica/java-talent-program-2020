package com.talent.java.noteswithoutdatabase.api;

import com.talent.java.noteswithoutdatabase.model.Note;
import com.talent.java.noteswithoutdatabase.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public List<Note> findNotes(){
        return noteService.findNotes();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> findNote(@PathVariable Long id){
        return noteService.findNote(id);
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody NoteRequest noteRequest){
        noteService.updateNote(noteRequest.title,noteRequest.content,id);
    }

    @PostMapping("/notes")
    public void createNote(@RequestBody NoteRequest noteRequest) {
        noteService.createNote(noteRequest.title, noteRequest.content);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    public static class NoteRequest {
        public String title;
        public String content;

    }
}
