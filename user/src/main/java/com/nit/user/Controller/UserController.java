package com.nit.user.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.user.Dto.LoginRequest;
import com.nit.user.Dto.RegisterRequest;
import com.nit.user.Dto.UserResponse;
import com.nit.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	@RequestMapping("/test")
		public String test() {
			return "User Testing the API";
		}
		
		@PostMapping("/register")
		public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
			
			UserResponse response=userService.register(request);
			return  new  ResponseEntity <>(response, HttpStatus.CREATED);
		}
		public ResponseEntity<UserResponse> login (@Valid @RequestBody LoginRequest request)
		{
			UserResponse response=userService.login(request);
			return  new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<UserResponse> findById(@PathVariable Long id ){
			
			UserResponse response =userService.findById(id);
			
			return ResponseEntity.ok(response);
			
		}
			
			
		}
	
