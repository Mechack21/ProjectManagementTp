/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.controller;

import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.service.ProjectService;
import com.springtrainingtp.projectmanagement.utils.HttpResponse;
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
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //SAVE PROJECT REST API 
    @PostMapping
    public ResponseEntity saveProject(@RequestBody Project project) {

        HttpResponse hr = new HttpResponse();

        try {
            Project p = this.projectService.saveProject(project);
            if (project != null) {
                hr.setCode("200");
                hr.setMessage("succes");
                hr.setData(p);
            } else {
                hr.setCode("400");
                hr.setMessage("echec d'enregistrement");
            }

            return ResponseEntity.ok(hr);
        } catch (Exception e) {
        }

        hr.setCode("400");
        return ResponseEntity.ok(hr);

    }

    //GET ALL PROJECT REST API
    @GetMapping
    public ResponseEntity getAllProjet() {
        HttpResponse hr = new HttpResponse();

        try {

            List<Project> projects = projectService.getAllProjects();
            hr.setCode("200");
            hr.setData(projects);
            return ResponseEntity.ok(hr);
        } catch (Exception e) {
        }
        hr.setCode("400");
        return ResponseEntity.ok(hr);

    }

    //GET PROJECT BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity getProjectById(@PathVariable("id") Long projectId) {

        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }

    //UPDATE PROJECT REST API
    @PutMapping("{id}")
    public ResponseEntity updateProject(@PathVariable("id") Long id, @RequestBody Project project) {

        return ResponseEntity.ok(projectService.updateProject(project, id));

    }

    //DELETE PROJECT REST API
    @DeleteMapping("{id}")
    public ResponseEntity deleteProject(@PathVariable("id") Long id) {

        projectService.deleteProject(id);

        return ResponseEntity.ok("Project deleted successfuly");
    }
}
