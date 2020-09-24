package com.talent.java.notes.repository;

import com.talent.java.notes.model.Note;
import com.talent.java.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Transactional
    @Modifying
    @Query("update Note n set n.title = ?1, n.content = ?2, n.user = ?3 where n.id = ?4")
    void update(String title, String content, User user, Long id);

//    @Query("select n from Note n join n.tags t where t.id = ?1")
//    List<Note> findNoteByTagId(Long tagId);

    List<Note> findByTags_Id(Long tagId);
}
