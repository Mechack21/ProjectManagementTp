/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.controller;

import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.model.UserProfile;
import com.springtrainingtp.projectmanagement.service.UserProfileService;
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
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    //SAVE USERPROFILE REST API 
    @PostMapping
    public ResponseEntity saveUserProfile(@RequestBody UserProfile userProfile) {

        HttpResponse hr = new HttpResponse();

        try {
            UserProfile up = this.userProfileService.saveUserProfile(userProfile);
            if (userProfile != null) {
                hr.setCode("200");
                hr.setMessage("succes");
                hr.setData(up);
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

    //GET ALL USERPROFILE REST API
    @GetMapping
    public ResponseEntity getAllUserProfile() {
        HttpResponse hr = new HttpResponse();

        try {

            List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
            hr.setCode("200");
            hr.setData(userProfiles);
            return ResponseEntity.ok(hr);
        } catch (Exception e) {
        }
        hr.setCode("400");
        return ResponseEntity.ok(hr);

    }

    //GET PROJECT BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity getUserProfileById(@PathVariable("id") Long useprofileId) {

        return ResponseEntity.ok(userProfileService.getUserProfileById(useprofileId));
    }

    //UPDATE USERPROFILE REST API
    @PutMapping("{id}")
    public ResponseEntity updateUserProfile(@PathVariable("id") Long id, @RequestBody UserProfile userProfile) {

        return ResponseEntity.ok(userProfileService.updateUserProfile(userProfile, id));

    }

    //DELETE PROJECT REST API
    @DeleteMapping("{id}")
    public ResponseEntity deleteUserProfile(@PathVariable("id") Long id) {

        userProfileService.deleteUserProfile(id);

        return ResponseEntity.ok("User Profile deleted successfuly");
    }
}
