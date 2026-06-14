package com.nit.applicationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.applicationservice.entity.JobApplication;

public interface ApplicationRepository  extends JpaRepository<JobApplication,Long>{
	
	 List<JobApplication> findByUserId(Long userId);

	 List<JobApplication> findByJobId(Long jobId);

}
