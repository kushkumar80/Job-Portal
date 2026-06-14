package com.nit.applicationservice.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nit.applicationservice.dto.ApplicationRequestDto;
import com.nit.applicationservice.dto.ApplicationResponseDto;
import com.nit.applicationservice.dto.JobResponseDto;
import com.nit.applicationservice.dto.UserResponse;
import com.nit.applicationservice.entity.ApplicationStatus;
import com.nit.applicationservice.entity.JobApplication;
import com.nit.applicationservice.exception.ApplicationNotFoundException;
import com.nit.applicationservice.dto.UserResponse;
import com.nit.applicationservice.repository.ApplicationRepository;
import com.nit.applicationservice.service.ApplicationService;
@Service 
public class ApplicationServiceImpl  implements ApplicationService{
	
	private final ApplicationRepository applrep;
	private final ModelMapper modelMapper;
	private final RestTemplate  restTemplate;

	public ApplicationServiceImpl(ApplicationRepository applrep, ModelMapper modelMapper, RestTemplate restTemplate) {
		
	  this.applrep= applrep;
	  this.modelMapper=modelMapper;
	  this.restTemplate=restTemplate;
			  
	}
	
	@Override
	public ApplicationResponseDto applyjob(ApplicationRequestDto request) {
		
		UserResponse user= restTemplate.getForObject("http://USER-SERVICE/api/users/" +request.getUserId(),UserResponse.class);
		
		JobResponseDto job= restTemplate.getForObject("http://JOB-SERVICE/api/job/" +request.getJobId(), JobResponseDto.class);
		
		if(user==null) {
			throw new RuntimeException("User not found");
		}
		if (job==null) {
			throw new RuntimeException("Job not Found");
		}
		
		JobApplication jobappl=new JobApplication();
		jobappl.setUserId(request.getUserId());
		jobappl.setJobId(request.getJobId());
		jobappl.setStatus(ApplicationStatus.APPLIED);
		
		JobApplication savedApplication=applrep.save(jobappl);
		
		return modelMapper.map(savedApplication, ApplicationResponseDto.class);
		
	}

	@Override
	public ApplicationResponseDto getApplicationById(Long id) {
		
		JobApplication jobappl=applrep.findById(id)
				.orElseThrow(() -> 
				new ApplicationNotFoundException("Application job not found with id " +id));
		
		return modelMapper.map(jobappl, ApplicationResponseDto.class);
	}

	@Override
	public List<ApplicationResponseDto> getAllApplications() {
		
		return applrep.findAll().stream().map(application->
		modelMapper.map(application, ApplicationResponseDto.class)).toList();
	}

	@Override
	public void deleteApplication(Long id) {
		JobApplication application =applrep.findById(id)
				.orElseThrow(() ->
				new ApplicationNotFoundException("Application Job not found" +id ));
				
		 applrep.delete(application);	}

}
