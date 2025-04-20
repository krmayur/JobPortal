package com.krmayur.JobPortal.repository;

import com.krmayur.JobPortal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobseekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
