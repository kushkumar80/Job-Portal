package com.nit.user.Dto;

import com.nit.user.entity.Role;

public class UserResponse {
	
	private Long id ;
	 private String name;
	 private String email;
	 private Role roles;
	 
	 public UserResponse() {
		 
	 }
	 
	 public UserResponse(Long id, String name,String email, Role roles) {
		 this.id=id;
		 this.name=name;
		 this.email=email;
		 this.roles=roles;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public Role getRoles() {
		 return roles;
	 }

	 public void setRoles(Role roles) {
		 this.roles = roles;
	 }
	 
	 
	

}
