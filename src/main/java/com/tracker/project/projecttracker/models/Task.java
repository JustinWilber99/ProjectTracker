package com.tracker.project.projecttracker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long task_id;

    private String task_description;
    private String task_note;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "user_tasks")
    private User task_to;

    private LocalDate task_start_date;
    private LocalDate task_end_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "project_tasks")
    private Project task_project;

}

