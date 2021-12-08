/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service;

import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.model.Task;
import java.util.List;

/**
 *
 * @author HP
 */
public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    List<Task> getTasksByProject(Project project);

    Task updateTask(Task task, Long id);

    void deleteTask(Long id);
}
