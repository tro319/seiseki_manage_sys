package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Subject;

@Repository

public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
	
	
	Optional<Subject> findByName(String name);
	
	Boolean existsByName(String name);
	
	

}
