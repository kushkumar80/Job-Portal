package com.nit.user.service;

import com.nit.user.Dto.LoginRequest;
import com.nit.user.Dto.RegisterRequest;
import com.nit.user.Dto.UserResponse;

public interface UserService {
	
	public UserResponse register (RegisterRequest  request) ;
	
	public UserResponse login (LoginRequest request);
	 
	
	

}
