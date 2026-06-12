package com.nit.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.user.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	

}
