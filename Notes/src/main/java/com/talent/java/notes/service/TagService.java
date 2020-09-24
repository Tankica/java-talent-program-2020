package com.talent.java.notes.service;

import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.TagRepository;
import com.talent.java.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;
    private UserRepository userRepository;

    @Autowired
    public TagService(TagRepository tagRepository, UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }

    public Tag createTag(String name, Long userId) {
        User user = userRepository.findById(userId).get();
        Tag tag = new Tag(name, user);
        return tagRepository.save(tag);
    }

    public List<Tag> findTags(User user) {
        return tagRepository.findByUser(user);
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
