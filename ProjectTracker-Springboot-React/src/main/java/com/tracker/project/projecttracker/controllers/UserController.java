package com.tracker.project.projecttracker.controllers;

import com.tracker.project.projecttracker.exceptions.ResourceNotFoundException;
import com.tracker.project.projecttracker.models.Mail;
import com.tracker.project.projecttracker.models.Project;
import com.tracker.project.projecttracker.models.Task;
import com.tracker.project.projecttracker.models.User;
import com.tracker.project.projecttracker.models.UserRole;
import com.tracker.project.projecttracker.services.MailService;
import com.tracker.project.projecttracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;
    private final MailService mailService;

    @Autowired
    public UserController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User u){
        String username = u.getUsername();
        String password = u.getPassword();
        System.out.println("U is "+ u);
        User user = this.userService.findByUsername(username)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not Found")
                );
        if (user.getPassword().equals(password)){
            return ResponseEntity.ok().body(user);
        }else {
            throw new ResourceNotFoundException("Pass is incorrect");
        }
    }
    
    @CrossOrigin
    @PostMapping("/email")
    public String sendEmail(@RequestBody Mail mail)
    {
    	String result = "Email sent successfully.";
    	try {
    		mailService.sendEmail(mail);
    	} catch(Exception ex) {result = ex.getMessage();}
    	return result;
	}

    @CrossOrigin
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return this.userService.save(user);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(
                this.userService.findAll()
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(this.userService.findById(id).orElseThrow(null));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable(value = "id") Long id){
        return this.userService.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setUserRole(newUser.getUserRole());
                    return this.userService.save(user);
                })
                .orElseGet(() ->{
                    newUser.setUser_id(id);
                    return this.userService.save(newUser);
                });
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable(value = "id") Long id){
        User user = this.userService.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not Found")
                );
        this.userService.delete(user);
        return ResponseEntity.ok().build();
    }
    
    

}
