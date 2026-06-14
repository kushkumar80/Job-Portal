package com.nit.jobhire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.jobhire.entity.Job;

public interface JobRepository  extends JpaRepository<Job,Long>{

}
