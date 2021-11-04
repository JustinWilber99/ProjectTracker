package com.tracker.project.projecttracker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
