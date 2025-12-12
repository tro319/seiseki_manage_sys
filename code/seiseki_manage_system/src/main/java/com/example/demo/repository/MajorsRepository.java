package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Major;

@Repository

public interface MajorsRepository extends JpaRepository<Major, Integer> {
	
	
	Optional<Major> findByName(String name);
	
	Boolean existsByName(String name);
	
	

}
