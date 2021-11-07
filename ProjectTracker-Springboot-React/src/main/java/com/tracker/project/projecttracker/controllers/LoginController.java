package com.tracker.project.projecttracker.controllers;

import com.tracker.project.projecttracker.exceptions.ResourceNotFoundException;
import com.tracker.project.projecttracker.models.User;
import com.tracker.project.projecttracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


}

