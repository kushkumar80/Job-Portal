package com.nit.applicationservice.dto;

import jakarta.validation.constraints.NotNull;

public class ApplicationRequestDto {
	
	
	@NotNull(message="user Id is required")
	private Long userId;
	@NotNull(message="job Id is required")
	private Long jobId;
	
	public ApplicationRequestDto() {
		
	}
	
	public ApplicationRequestDto( Long userId,Long jobId) {
		this.userId = userId;
		this.jobId = jobId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}	

}
