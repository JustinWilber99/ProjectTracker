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
@Table(name="user_table")

public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private UserRole userRole;
    private String profpic;
    
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> user_projects = new ArrayList<>();
    @OneToMany(mappedBy = "task_to", fetch = FetchType.LAZY)
    private List<Task> user_tasks = new ArrayList<>();



    public void addProject(Project project){
        this.user_projects.add(project);
    }



	public Long getUser_id() {
		return user_id;
	}



	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public UserRole getUserRole() {
		return userRole;
	}



	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



	public List<Project> getUser_projects() {
		return user_projects;
	}



	public void setUser_projects(List<Project> user_projects) {
		this.user_projects = user_projects;
	}



	public List<Task> getUser_tasks() {
		return user_tasks;
	}



	public void setUser_tasks(List<Task> user_tasks) {
		this.user_tasks = user_tasks;
	}



	public String getProfpic() {
		return profpic;
	}



	public void setProfpic(String profpic) {
		this.profpic = profpic;
	}

}
