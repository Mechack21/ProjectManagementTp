/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service.impl;

import com.springtrainingtp.projectmanagement.exception.ResourceNotFoundException;
import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.repository.ProjectRepository;
import com.springtrainingtp.projectmanagement.service.ProjectService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */

@Service
public class ProjectServiceImpl implements ProjectService{
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Override
    public Project saveProject(Project project) {
       
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
       
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
       
//        Optional<Project> project = projectRepository.findById(id);
//        if (project.isPresent()) {
//            
//            return project.get();
//        }else{
//        
//            throw new ResourceNotFoundException("Project", "id", id);
//        }
        return projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project", "id", id));

    }

    @Override
    public Project updateProject(Project project, Long id) {
        
        Project existingProject = projectRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Project", "id", id));
        existingProject.setName(project.getName());
        existingProject.setAuthor(project.getAuthor());
        projectRepository.save(existingProject);
        
        return existingProject;
    }

    @Override
    public void deleteProject(Long id) {
        
        projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project", "id", id));
        projectRepository.deleteById(id);
    }
    
}
