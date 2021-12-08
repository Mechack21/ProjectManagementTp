/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.controller;


import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.model.Task;
import com.springtrainingtp.projectmanagement.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
     //SAVE TASK REST API 
    
    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task tsTask){
    
        return ResponseEntity.ok(taskService.saveTask(tsTask));
    }
    
    //GET ALL TASK REST API
    @GetMapping
    public List<Task> getAllTasks(){
    
        return taskService.getAllTasks();
    }
    
    //GET TASK BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Task> getTasksById(@PathVariable("id")Long taskId){
        
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    
    }
    
    //GET TASK BY PROJECT REST API
    @GetMapping(value = "taskbyproject/{id}")
    public ResponseEntity getTaskByProject (@PathVariable("id") Long projectId){
    
       return ResponseEntity.ok(this.taskService.getTasksByProject(new Project(projectId)));
    }
    
    //UPDATE TASK REST API
    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task){
    
        return ResponseEntity.ok(taskService.updateTask(task, id));
    
    }
    
    //DELETE TASK REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id){
        
        taskService.deleteTask(id);
        
        return ResponseEntity.ok("The Task was delected successfully");
    
    }
}
