package com.talent.java.notes.repository;

import com.talent.java.notes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
