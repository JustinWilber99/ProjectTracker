package com.tracker.project.projecttracker.services;

import com.tracker.project.projecttracker.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Optional<Task> findById(Long id);

    List<Task> findAll();

    Task save(Task task);

    Task update(Task task);

    void deleteById(Long id);

    void delete(Task task);
}
