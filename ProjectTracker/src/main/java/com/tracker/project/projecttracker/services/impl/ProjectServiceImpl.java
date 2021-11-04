package com.tracker.project.projecttracker.services.impl;

import com.tracker.project.projecttracker.models.Project;
import com.tracker.project.projecttracker.repository.ProjectRepository;
import com.tracker.project.projecttracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository repository;

    @Override
    public Optional<Project> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return (List<Project>) repository.findAll();
    }

    @Override
    public Project save(Project project) {
        return repository.save(project);

    }

    @Override
    public Project update(Project project) {
        return repository.save(project);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Project project) {
        repository.delete(project);
    }
}
