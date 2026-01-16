package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.ClassSubject;
import com.example.demo.model.entity.Manager;
import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.ClassSubjectAddForm;
import com.example.demo.repository.ClassSubjectsRepository;

import lombok.RequiredArgsConstructor;



/* ClassSubjectServiceクラス (class教科情報関係サービスクラス)
 * 
 * @author ys
 * 
 */

@Service
@RequiredArgsConstructor

public class ClassSubjectService {
	
	private final ClassService classService;
	
	private final SubjectService subjectService;
	
	private final ManagerService managerService;
	
	private final ClassSubjectsRepository repository;
	
	
	
	/* すべてのクラス教科エンティティ群を取得
	 * 
	 * @param classId 指定されたクラスid
	 * 
	 * @return クラス教科一覧情報
	 * 
	 */
	
	public List<ClassSubject> getClassSubjects(Integer classId) {
		
		List<ClassSubject> classSubjectsInfo = repository.findAll();
		
		ClassEntity classInfo = classService.getClassById(classId);
		
		classSubjectsInfo = classSubjectsInfo.stream().filter(classSubject -> classSubject.getClassEntity().getId() == classInfo.getId()).toList();
		
		return classSubjectsInfo;
		
	}
	
	
	/* idからクラス教科エンティティ1件を取得
	 * 
	 * @param id 指定されたクラス教科id
	 * @return クラス教科エンティティ1件
	 * 
	 */
	
	public ClassSubject getClassSubjectById(Integer id) {
		
		ClassSubject classSubjectInfo = repository.findById(id).orElse(null);
		
		return classSubjectInfo;
		
	}
	
	
	/* idからクラス教科エンティティ1件を削除
	 * 
	 * @param id 指定されたクラス教科id
	 * 
	 */
	
	public void deleteClassSubjectById(Integer id) {
		
		repository.deleteById(id);
		
	}
	
	/* クラス教科追加用フォーム入力情報からクラス教科エンティティ1件を追加
	 * 
	 * @param form クラス教科追加用フォーム入力情報
	 * 
	 * @return 追加されたクラス教科エンティティ1件
	 * 
	 */
	
	public ClassSubject registerClassSubject(ClassSubjectAddForm form) {
		
		ClassSubject classSubjectInfo = new ClassSubject();
		
		ClassEntity classInfo = classService.getClassById(form.getClassId());
		
		Manager managerInfo = managerService.getManagerById(form.getManagerId());
		
		Subject subjectInfo = subjectService.getSubjectById(form.getSubjectId());
		
		
		classSubjectInfo.setClassEntity(classInfo);
		
		classSubjectInfo.setManager(managerInfo);
		
		classSubjectInfo.setSubject(subjectInfo);
		
		return repository.save(classSubjectInfo);
		
	}
	
	

}
