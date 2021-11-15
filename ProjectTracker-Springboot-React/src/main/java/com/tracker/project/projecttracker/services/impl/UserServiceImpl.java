package com.tracker.project.projecttracker.services.impl;

import com.tracker.project.projecttracker.models.User;
import com.tracker.project.projecttracker.repository.UserRepository;
import com.tracker.project.projecttracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);

    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUser(Long id) {
        User user = findAll().stream()
                .filter(t -> id.equals(t.getUser_id()))
                .findFirst()
                .orElse(null);
        return user;
    }


}
