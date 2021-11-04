package com.tracker.project.projecttracker.services;

import com.tracker.project.projecttracker.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

    User update(User user);

    void deleteById(Long id);

    void delete(User user);

    Optional<User> findByUsername(String username);

    User findByEmail(String email);

    User getUser(Long id);
}
