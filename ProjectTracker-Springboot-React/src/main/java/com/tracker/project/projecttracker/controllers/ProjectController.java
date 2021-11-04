package com.tracker.project.projecttracker.controllers;

import com.tracker.project.projecttracker.exceptions.ResourceNotFoundException;
import com.tracker.project.projecttracker.models.Project;
import com.tracker.project.projecttracker.models.Task;
import com.tracker.project.projecttracker.models.User;
import com.tracker.project.projecttracker.services.ProjectService;
import com.tracker.project.projecttracker.services.TaskService;
import com.tracker.project.projecttracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private  ProjectService projectService;
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;


    @PostMapping("/project/save")
    public Project saveProject(@RequestBody Project project){
        System.out.println(project);
        return this.projectService.save(project);
    }
    @PostMapping("/project/adduser/{projectid}/{userid}")
    public Project addUserToProject(@PathVariable(value = "projectid") Long projectid,@PathVariable(value = "userid") Long userid){
        User user = this.userService.findById(userid).orElseThrow(
                () -> new ResourceNotFoundException("User could not be found!")
        );
        Project project = this.projectService.findById(projectid).orElseThrow(
                () -> new ResourceNotFoundException("Project could not be found!")
        );
        project.addUserToProject(user);
        user.addProject(project);
        userService.save(user);
        return this.projectService.save(project);
    }

    @PostMapping("/project/addtask/{projectid}/{taskid}")
    public Project addTaskToProject(@PathVariable(value = "projectid") Long projectid,@PathVariable(value = "taskid") Long taskid){
        Task task = this.taskService.findById(taskid).orElseThrow(
                () -> new ResourceNotFoundException("Task could not be found!")
        );
        Project project = this.projectService.findById(projectid).orElseThrow(
                () -> new ResourceNotFoundException("Project could not be found!")
        );
        project.addTaskToProject(task);
        task.setTask_project(project);
        taskService.save(task);
        return this.projectService.save(project);
    }

    @GetMapping("/project/all")
    public ResponseEntity<List<Project>> getProjects(){
        return ResponseEntity.ok(
                this.projectService.findAll()
        );
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProject(@PathVariable(value = "id") Long id){
        Project project = this.projectService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Project not found!")
        );
        return ResponseEntity.ok().body(project);
    }

    @PutMapping("/project/{id}")
    public Project updateProject(@RequestBody Project newProject, @PathVariable(value = "id") Long id){
        return this.projectService.findById(id)
                .map(project -> {
                    project.setProject_name(newProject.getProject_name());
                    project.setProject_users(newProject.getProject_users());
                    project.setTasks(newProject.getTasks());
                    project.setStart_project_date(newProject.getStart_project_date());
                    project.setEnd_project_date(newProject.getEnd_project_date());

                    return this.projectService.save(project);
                })
                .orElseGet(() ->{
                    newProject.setProject_id(id);
                    return this.projectService.save(newProject);
                });
    }
    @PostMapping("/project/adduser/{id}")
    public Project addProject(@RequestBody User user, @PathVariable(value = "id") Long id){
        Project project = this.projectService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Project not found!")
        );
        project.addUserToProject(user);
        return this.projectService.save(project);
    }

    @DeleteMapping("project/{id}")
    public ResponseEntity<Void> removeProject(@PathVariable(value = "id") Long id){
        Project project = this.projectService.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Project not Found")
                );
        this.projectService.delete(project);
        return ResponseEntity.ok().build();
    }
}
