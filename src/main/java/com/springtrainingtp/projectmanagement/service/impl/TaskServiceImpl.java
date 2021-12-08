/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service.impl;

import com.springtrainingtp.projectmanagement.exception.ResourceNotFoundException;
import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.model.Task;
import com.springtrainingtp.projectmanagement.repository.TaskRepository;
import com.springtrainingtp.projectmanagement.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        
        return taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "id", id));
    }

    @Override
    public List<Task> getTasksByProject(Project project) {
        
        return this.taskRepository.findAllByProject(project.getId());
    }

    @Override
    public Task updateTask(Task task, Long id) {
        
        Task existingTask = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "id", id));
        
        existingTask.setDescription(task.getDescription());
        existingTask.setProject(task.getProject());
        taskRepository.save(existingTask);
        
        return existingTask;
    }

    @Override
    public void deleteTask(Long id) {
       
        taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "id", id));
        taskRepository.deleteById(id);
    }

}
