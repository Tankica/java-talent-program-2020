package com.talent.java.notes.api;

import com.talent.java.notes.model.Tag;
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

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag createTag(@RequestBody CreateTagRequest tagRequest) {
        return tagService.createTag(tagRequest.name);
    }

    public static class CreateTagRequest {
        public String name;
    }

    @GetMapping("/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTag(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Tag> findTags() {
        return tagService.findTags();
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
