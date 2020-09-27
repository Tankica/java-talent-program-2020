package com.talent.java.notes.api;

import com.talent.java.notes.model.User;
import com.talent.java.notes.security.SecurityService;
import com.talent.java.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/me")
    public User findAuthenticatedUsers() {
        return securityService.getAuthenticatedUsers();
    }
}
