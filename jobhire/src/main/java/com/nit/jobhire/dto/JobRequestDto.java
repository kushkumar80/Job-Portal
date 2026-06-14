package com.nit.jobhire.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JobRequestDto {

	
	@NotBlank(message=" Jobt title is required ")
	@Size(min=3,max=100 ,message="Title must be between 3 and 100 characters")
	private String title;
	@NotBlank(message="Company name is required")
	private String company;
	@NotBlank(message="Location is required")
	private String location;
	@NotNull(message="Salary is the required")
	@Min(value=10000, message="Salary must be greater than 10000")
	private Double salary;
	@NotBlank(message="Job Description is required")
	@Size(min=10 ,max=1000, message="Job description must be between 10 and 1000 characters")
	private String description;
	@NotBlank(message="RecuriterId is required")
	private Long recruiterId;
	
	
	public JobRequestDto() {
		
	}


	public JobRequestDto(String title, String company, String location,
            Double salary, String description, Long recruiterId) {
			
		this.title = title;
		this.company = company;
		this.location = location;
		this.salary = salary;
		this.description = description;
		this.recruiterId = recruiterId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getRecruiterId() {
		return recruiterId;
	}


	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
}
