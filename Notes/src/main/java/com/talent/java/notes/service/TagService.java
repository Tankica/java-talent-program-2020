package com.talent.java.notes.service;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.TagRepository;
import com.talent.java.notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;
    private SecurityService securityService;
    private NoteService noteService;

    @Autowired
    public TagService(TagRepository tagRepository, SecurityService securityService, NoteService noteService) {
        this.tagRepository = tagRepository;
        this.securityService = securityService;
        this.noteService = noteService;
    }

    public Tag createTag(String name) {
        User user = securityService.getAuthenticatedUser();

        Tag tag = new Tag(name, user);
        return tagRepository.save(tag);
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findTags() {
        User user = securityService.getAuthenticatedUser();
        return tagRepository.findByUser(user);
    }

    public Tag updateTag(Long id, String name) {
        Tag tag = tagRepository.findById(id).get();
        tag.setName(name);
        return tagRepository.save(tag);
    }

    public void deleteTag(Long id) {
        Tag tag = findTag(id).get();
        noteService.deleteTagsFromNotes(tag);
        tagRepository.deleteById(id);
    }

}
