package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="subjects")

public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String kana;
	
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL)
	@ToString.Exclude
	private List<ClassSubject> classSubjects;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	@PrePersist 
	public void onCreate() {
		
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		
	}
	
	@PreUpdate
	public void onUpdate() {
		
		this.updatedAt = LocalDateTime.now();
		
	}
	
	
	

}
