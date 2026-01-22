package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassSubject;

@Repository

public interface ClassSubjectsRepository extends JpaRepository<ClassSubject, Integer> {
	
	
	
	
	
}
