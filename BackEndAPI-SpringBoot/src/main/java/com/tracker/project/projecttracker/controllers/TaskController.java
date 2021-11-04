package com.tracker.project.projecttracker.controllers;

import com.tracker.project.projecttracker.exceptions.ResourceNotFoundException;
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
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;


    @PostMapping("/task/save/{id}")
    public Task saveTask(@RequestBody Task task,@PathVariable(value = "id") Long id){
        User user = this.userService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found!")
        );
        task.setTask_to(user);
        return this.taskService.save(task);
    }

    @GetMapping("/task/all")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(
                this.taskService.findAll()
        );
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable(value = "id") Long id){
        Task task = this.taskService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task not found!")
        );
        return ResponseEntity.ok().body(task);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable(value = "id") Long id){
        return this.taskService.findById(id)
                .map(task -> {
                    task.setTask_description(newTask.getTask_description());
                    task.setTask_to(newTask.getTask_to());
                    task.setTask_note(newTask.getTask_note());
                    task.setTask_start_date(newTask.getTask_start_date());
                    task.setTask_end_date(newTask.getTask_end_date());
                    task.setTask_project(newTask.getTask_project());
                    return this.taskService.save(task);
                })
                .orElseGet(() ->{
                    newTask.setTask_id(id);
                    return this.taskService.save(newTask);
                });
    }

    @DeleteMapping("task/{id}")
    public ResponseEntity<Void> removeTask(@PathVariable(value = "id") Long id){
        Task task = this.taskService.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Task not Found Couldn't Delete")
                );
        this.taskService.delete(task);
        return ResponseEntity.ok().build();
    }
}
