package com.tracker.project.projecttracker.services;

import com.tracker.project.projecttracker.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Optional<Project> findById(Long id);

    List<Project> findAll();

    Project save(Project project);

    Project update(Project project);

    void deleteById(Long id);

    void delete(Project project);
}
