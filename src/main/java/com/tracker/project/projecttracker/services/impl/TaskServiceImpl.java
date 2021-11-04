package com.tracker.project.projecttracker.services.impl;

import com.tracker.project.projecttracker.models.Task;
import com.tracker.project.projecttracker.repository.TaskRepository;
import com.tracker.project.projecttracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepository repository;

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) repository.findAll();
    }

    @Override
    public Task save(Task task) {
        return repository.save(task);

    }

    @Override
    public Task update(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Task task) {
        repository.delete(task);
    }

}
