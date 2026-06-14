package com.nit.user.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.nit.user.Dto.LoginRequest;
import com.nit.user.Dto.RegisterRequest;
import com.nit.user.Dto.UserResponse;
import com.nit.user.Repository.UserRepository;
import com.nit.user.entity.Role;
import com.nit.user.entity.User;
import com.nit.user.exception.EmailAlreadyExistException;
import com.nit.user.exception.InvalidCredentialsException;
import com.nit.user.exception.UserNotFoundException;
import com.nit.user.service.UserService;

@Service

public class UserServiceImpl  implements UserService{
	
	private  final UserRepository ussr;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository ussr, ModelMapper modelMapper) {
		this.modelMapper=modelMapper;
		this.ussr=ussr;
		
		
		
	}
	

	@Override
	public UserResponse register(RegisterRequest request) {
		
		if(ussr.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyExistException("Email already exists" + request.getEmail());
			
			}
		
		User user=modelMapper.map(request, User.class);
		
		user.setRole(Role.valueOf(request.getRole().toUpperCase()));
		
		User savedUser=ussr.save(user);
		
		return modelMapper.map(savedUser,UserResponse.class);
	
	}
	@Override
	public UserResponse login(LoginRequest request) {
		
		User user = ussr.findByEmail(request.getEmail())
		        .orElseThrow(() ->
		                new InvalidCredentialsException("Invalid email or password"));;
	       
	     if(!user.getPassword().equals(request.getPassword())) {
	    	 throw new  InvalidCredentialsException("Invalid Email and password ");
	     }
	     
	    	 return modelMapper.map(user ,UserResponse.class);
		
		
	     }


	@Override
	public UserResponse findById(Long id) {
		
		User user=ussr.findById(id)
				.orElseThrow(()->
					new UserNotFoundException(" user not found " + id));
		
		return modelMapper.map(user, UserResponse.class);
	
		
		
		
	
	}
		
	}
	
	
