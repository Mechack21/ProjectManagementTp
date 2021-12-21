/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service;

import com.springtrainingtp.projectmanagement.model.UserProfile;
import com.springtrainingtp.projectmanagement.repository.UserProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {

        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileById(Long id) {

        return userProfileRepository.findById(id).get();
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile, Long id) {

        UserProfile existingUserProfile = userProfileRepository.findById(id).get();
        existingUserProfile.setUserName(userProfile.getUserName());
        existingUserProfile.setPassword(userProfile.getPassword());

        userProfileRepository.save(existingUserProfile);
        return existingUserProfile;
    }

    @Override
    public void deleteUserProfile(Long id) {
        
        userProfileRepository.deleteById(id);
    }

}
