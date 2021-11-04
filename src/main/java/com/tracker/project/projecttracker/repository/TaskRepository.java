package com.tracker.project.projecttracker.repository;

import com.tracker.project.projecttracker.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}

