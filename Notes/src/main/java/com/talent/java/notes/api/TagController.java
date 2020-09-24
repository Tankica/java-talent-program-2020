package com.talent.java.notes.api;

import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.security.SecurityService;
import com.talent.java.notes.service.NoteService;
import com.talent.java.notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private TagService tagService;
    private SecurityService securityService;
    private NoteService noteService;

    @Autowired
    public TagController(TagService tagService, SecurityService securityService, NoteService noteService) {
        this.tagService = tagService;
        this.securityService = securityService;
        this.noteService = noteService;
    }

    @PostMapping
    public Tag createTag(@RequestBody CreateTagRequest tagRequest) {
        return tagService.createTag(tagRequest.name, tagRequest.userId);
    }

    public static class CreateTagRequest {
        public String name;
        public Long userId;
    }

    @GetMapping("/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Tag> findTags() {
        User user = securityService.getAuthenticatedUsers();
        return tagService.findTags(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        Tag tag = tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        noteService.deleteTagsFromNotes(tag);
        tagService.deleteTag(id);
    }
}
