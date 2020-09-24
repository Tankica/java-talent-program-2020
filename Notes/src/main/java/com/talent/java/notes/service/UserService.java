package com.talent.java.notes.service;

import com.talent.java.notes.model.User;
import com.talent.java.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
