package com.nit.applicationservice.service;

import java.util.List;

import com.nit.applicationservice.dto.ApplicationRequestDto;
import com.nit.applicationservice.dto.ApplicationResponseDto;

public interface ApplicationService {

	ApplicationResponseDto applyjob( ApplicationRequestDto request);
     ApplicationResponseDto getApplicationById(Long id);
     List< ApplicationResponseDto> getAllApplications();
	 void deleteApplication(Long id);
     

}
