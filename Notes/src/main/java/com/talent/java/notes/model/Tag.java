package com.talent.java.notes.model;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    public Tag() {
    }

    public Tag(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
