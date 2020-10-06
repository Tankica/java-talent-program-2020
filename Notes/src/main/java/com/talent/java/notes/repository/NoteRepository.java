package com.talent.java.notes.repository;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);

    List<Note> findByTags_IdAndUser(Long tagId, User user);

//    @Query("select n from Note n join n.tags t where t.id = ?1")
//    List<Note> findNoteByTagId(Long tagId);

}
