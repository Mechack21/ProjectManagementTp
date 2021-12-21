/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.service;

import com.springtrainingtp.projectmanagement.model.Project;
import com.springtrainingtp.projectmanagement.model.UserProfile;
import java.util.List;

/**
 *
 * @author HP
 */
public interface UserProfileService {

    UserProfile saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUserProfiles();

    UserProfile getUserProfileById(Long id);

    UserProfile updateUserProfile(UserProfile userProfile, Long id);

    void deleteUserProfile(Long id);

}
