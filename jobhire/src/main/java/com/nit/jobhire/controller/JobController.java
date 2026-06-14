package com.nit.jobhire.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.jobhire.dto.JobRequestDto;
import com.nit.jobhire.dto.JobResponseDto;
import com.nit.jobhire.service.JobService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/job")
public class JobController {

private final JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService=jobService;
	}
	
	@RequestMapping("/testing")
	public String testing() {
		return "This is the testing of the Job-service";
	}
	
	@PostMapping("/save")
	
	public ResponseEntity<JobResponseDto> createJob(@Valid @RequestBody JobRequestDto request){
		
		JobResponseDto response=jobService.createJob(request);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	
	public ResponseEntity<JobResponseDto> getJobById(@PathVariable Long id ){
		JobResponseDto response=jobService.getJobById(id);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/all")
	
	public ResponseEntity<List<JobResponseDto>>getAllJobs(){
		
		List<JobResponseDto> response=jobService.getAllJobs();
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobResponseDto>updateJob(@Valid @RequestBody JobRequestDto request,@PathVariable long id )
	
	{
		JobResponseDto updateJob= jobService.updateJob(id, request) ;
		return ResponseEntity.ok(updateJob);
	}
	@DeleteMapping("/{id}")
	
	public ResponseEntity<String> deleteJob(@PathVariable long id ){
		jobService.deleteJob(id);
		return  ResponseEntity.ok("Deleted Successfully Jobs ");
	}
	
}
