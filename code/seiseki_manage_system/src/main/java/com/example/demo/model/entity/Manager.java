package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.Data;

/* Managerクラス (managersテーブルと紐ずくエンティティ)
 * 
 * @author ys
 * 
 */

@Entity
@Data
@Table(name="managers")

public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private String name;
	
	private String kana;
	
	private String email;
	
	private String pass;
	
	private String gender;
	
	
// 参照先クラス未実装 (消さないで!)
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Student> students;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Teacher> teachers;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Class> classes;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Subject> subjects;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Major> majors;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<Period> periods;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<TeacherSubject> teacherSubjects;
//	
//	@OneToMany(mappedBy="manager", cascade=CascadeType.ALL)
//	private List<ClassSubject> classSubjects;
	
	
	
	
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
