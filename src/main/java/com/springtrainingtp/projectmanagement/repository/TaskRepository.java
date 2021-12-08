/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.repository;

import com.springtrainingtp.projectmanagement.model.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HP
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t join t.project prjt WHERE prjt.id=:projectId")
    public List<Task> findAllByProject(@Param("projectId")Long projectId);

}
