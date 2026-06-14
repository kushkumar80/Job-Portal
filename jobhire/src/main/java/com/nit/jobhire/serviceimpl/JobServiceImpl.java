package com.nit.jobhire.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.nit.jobhire.dto.JobRequestDto;
import com.nit.jobhire.dto.JobResponseDto;
import com.nit.jobhire.entity.Job;
import com.nit.jobhire.exception.JobNotFoundException;
import com.nit.jobhire.repository.JobRepository;
import com.nit.jobhire.service.JobService;

@Service
public class JobServiceImpl  implements JobService{
	
	
	private final JobRepository jobre;
	private final ModelMapper modelMapper;
	
	public JobServiceImpl(JobRepository jobre, ModelMapper modelMapper) {
		this.jobre=jobre;
		this.modelMapper=modelMapper;
	}
	
	

	@Override
	public JobResponseDto createJob(JobRequestDto request) {
	
		Job job= modelMapper.map(request,Job.class);
		Job savedjob= jobre.save(job);
		return modelMapper.map(savedjob, JobResponseDto.class);
		
	}

	@Override
	public JobResponseDto getJobById(Long id) {
		
		Job job=jobre.findById(id)
				.orElseThrow(()->
				new JobNotFoundException("Job not found" +id));
		
		return modelMapper.map(job,JobResponseDto.class);
	}

	@Override
	public List<JobResponseDto> getAllJobs() {
		
		return jobre.findAll().stream().map(job->modelMapper.map(job, JobResponseDto.class)).toList();
	}

	@Override
	public JobResponseDto updateJob(long id, JobRequestDto request) {
		
		Job job=jobre.findById(id)
				.orElseThrow(()->  new JobNotFoundException("Job not found " +id));
		
		  job.setTitle(request.getTitle());
		  job.setDescription(request.getDescription());
		  job.setLocation(request.getLocation());
		  job.setCompany(request.getCompany());
		  job.setSalary(request.getSalary());
		  job.setRecruiterId(request.getRecruiterId());
		  
		  Job jobupdates=jobre.save(job);
		  return modelMapper.map(jobupdates, JobResponseDto.class);
		  
		
	}

	@Override
	public void deleteJob(long id) {
	
		 Job job = jobre.findById(id)
	                .orElseThrow(() ->
	                        new JobNotFoundException(
	                                "Job not found with id: " + id));

	        jobre.delete(job);
		
	}
	

}
