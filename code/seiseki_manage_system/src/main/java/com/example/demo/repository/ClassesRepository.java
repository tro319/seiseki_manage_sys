package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassEntity;

@Repository

public interface ClassesRepository extends JpaRepository<ClassEntity, Integer> {
	
	
	List<ClassEntity> findByStartYear(Integer startYear);
	
	
}
