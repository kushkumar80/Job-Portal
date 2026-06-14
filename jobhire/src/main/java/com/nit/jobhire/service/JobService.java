package com.nit.jobhire.service;

import java.util.List;

import com.nit.jobhire.dto.JobRequestDto;
import com.nit.jobhire.dto.JobResponseDto;

public interface JobService {
	

	JobResponseDto createJob( JobRequestDto request);

	JobResponseDto getJobById(Long id);

	List<JobResponseDto> getAllJobs();

	JobResponseDto updateJob(long id,  JobRequestDto request);

	void deleteJob(long id);

}
