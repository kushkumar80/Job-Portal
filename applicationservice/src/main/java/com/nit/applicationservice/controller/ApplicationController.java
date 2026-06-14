package com.nit.applicationservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.applicationservice.dto.ApplicationRequestDto;
import com.nit.applicationservice.dto.ApplicationResponseDto;
import com.nit.applicationservice.service.ApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications")

public class ApplicationController {
	
	private final ApplicationService applicationService;
	
	//constructor injection
	
	public ApplicationController(ApplicationService applicationService) {
		this.applicationService=applicationService;
	}
	
	@RequestMapping("/test")
	public String test() {
		
		return "Application service tested";
	}
	
	@PostMapping("/applyjob")
	public ResponseEntity<ApplicationResponseDto> applyjob(@Valid @RequestBody ApplicationRequestDto request){
		
		ApplicationResponseDto response=applicationService.applyjob(request);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	 @GetMapping("/{id}")
	    public ResponseEntity<ApplicationResponseDto>
	    getApplicationById(
	            @PathVariable Long id) {

	        return ResponseEntity.ok(
	                applicationService
	                        .getApplicationById(id));
	    }
		
		
	 @GetMapping("/all")
	    public ResponseEntity<List<ApplicationResponseDto>>
	    getAllApplications() {

	        return ResponseEntity.ok(
	                applicationService
	                        .getAllApplications());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String>
	    deleteApplication(
	            @PathVariable Long id) {

	        applicationService.deleteApplication(id);

	        return ResponseEntity.ok(
	                "Application deleted successfully");
	    }
		
	
	

}
