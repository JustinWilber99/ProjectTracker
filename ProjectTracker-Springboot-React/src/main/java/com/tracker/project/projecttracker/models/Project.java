package com.tracker.project.projecttracker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    private String project_name;
    @ManyToMany(mappedBy = "user_projects", fetch = FetchType.LAZY)
    @JsonBackReference(value = "user_projects")
    private List<User> project_users = new ArrayList<>();
    @OneToMany(mappedBy = "task_project", fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();
    private LocalDate start_project_date;
    private LocalDate end_project_date;

    public void addUserToProject( User user){
        this.project_users.add(user);
    }

    public void addTaskToProject( Task task){
        this.tasks.add(task);
    }

	public Long getProject_id() {
		return project_id;
	}

	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public List<User> getProject_users() {
		return project_users;
	}

	public void setProject_users(List<User> project_users) {
		this.project_users = project_users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public LocalDate getStart_project_date() {
		return start_project_date;
	}

	public void setStart_project_date(LocalDate start_project_date) {
		this.start_project_date = start_project_date;
	}

	public LocalDate getEnd_project_date() {
		return end_project_date;
	}

	public void setEnd_project_date(LocalDate end_project_date) {
		this.end_project_date = end_project_date;
	}



}
