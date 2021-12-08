/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service;

import com.springtrainingtp.projectmanagement.model.Project;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ProjectService {
    
    Project saveProject(Project project);
    List<Project> getAllProjects();
    Project getProjectById(Long id); 
    Project updateProject(Project project, Long id);
    void deleteProject(Long id);
    
}
