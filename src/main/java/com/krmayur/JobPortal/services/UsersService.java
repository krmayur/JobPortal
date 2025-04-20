package com.krmayur.JobPortal.services;


import com.krmayur.JobPortal.entity.JobSeekerProfile;
import com.krmayur.JobPortal.entity.RecruiterProfile;
import com.krmayur.JobPortal.entity.Users;
import com.krmayur.JobPortal.repository.JobseekerProfileRepository;
import com.krmayur.JobPortal.repository.RecruiterProfileRepository;
import com.krmayur.JobPortal.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository userRepository;
    private final JobseekerProfileRepository jobseekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;



    @Autowired

    public UsersService(UserRepository userRepository, JobseekerProfileRepository jobseekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.userRepository = userRepository;
        this.jobseekerProfileRepository=jobseekerProfileRepository;
        this.recruiterProfileRepository=recruiterProfileRepository;
    }

    public Users addNew(Users users)
    {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser=userRepository.save(users);
        int userTypeId= users.getUserTypeId().getUserTypeId();
        if(userTypeId==1)
        {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }
        else
        {
            jobseekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }


        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
}
