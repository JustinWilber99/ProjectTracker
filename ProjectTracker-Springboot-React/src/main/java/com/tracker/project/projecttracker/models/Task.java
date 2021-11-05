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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getTask_note() {
		return task_note;
	}

	public void setTask_note(String task_note) {
		this.task_note = task_note;
	}

	public User getTask_to() {
		return task_to;
	}

	public void setTask_to(User task_to) {
		this.task_to = task_to;
	}

	public LocalDate getTask_start_date() {
		return task_start_date;
	}

	public void setTask_start_date(LocalDate task_start_date) {
		this.task_start_date = task_start_date;
	}

	public LocalDate getTask_end_date() {
		return task_end_date;
	}

	public void setTask_end_date(LocalDate task_end_date) {
		this.task_end_date = task_end_date;
	}

	public Project getTask_project() {
		return task_project;
	}

	public void setTask_project(Project task_project) {
		this.task_project = task_project;
	}

}

