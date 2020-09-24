package com.talent.java.notes.repository;

import java.util.List;

import com.talent.java.notes.model.Tag;
import com.talent.java.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByUser(User user);
}
