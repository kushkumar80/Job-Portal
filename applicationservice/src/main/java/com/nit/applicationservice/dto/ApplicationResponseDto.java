package com.nit.applicationservice.dto;

import java.time.LocalDateTime;

import com.nit.applicationservice.entity.ApplicationStatus;

public class ApplicationResponseDto {
	
	private Long id;
	
	private Long userId;
	private Long jobId;
	private ApplicationStatus status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ApplicationResponseDto() {
		
	}

	

	public ApplicationResponseDto(Long id, Long userId, Long jobId, ApplicationStatus status, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.jobId = jobId;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	
	
	

}
