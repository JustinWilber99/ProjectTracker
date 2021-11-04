package com.tracker.project.projecttracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private UserRole userRole;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> user_projects = new ArrayList<>();
    @OneToMany(mappedBy = "task_to", fetch = FetchType.LAZY)
    private List<Task> user_tasks = new ArrayList<>();



    public void addProject(Project project){
        this.user_projects.add(project);
    }

}
