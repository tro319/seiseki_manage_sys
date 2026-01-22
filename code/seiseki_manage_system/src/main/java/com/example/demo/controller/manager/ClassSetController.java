package com.example.demo.controller.manager;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.ClassSubject;
import com.example.demo.model.entity.Major;
import com.example.demo.model.entity.Manager;
import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.ClassSetForm;
import com.example.demo.model.form.manager.ClassSubjectAddForm;
import com.example.demo.service.ClassService;
import com.example.demo.service.ClassSubjectService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* ClassSetController クラス (クラス更新処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassSetController {
	
	
	private final ClassService service;
	
	private final SubjectService subjectService;
	
	private final ManagerService managerService;
	
	private final ClassSubjectService classSubjectService;
	
	
	/* クラス取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id 該当クラスid
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_update")
	public String getClass(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/classes";
			
		}
		
		Integer classId = id;
		
	
		String setResult = (String)session.getAttribute("class_set_result");
		
		if (setResult != null) {
			
			redirectAttributes.addFlashAttribute("class_set_result", setResult);
			
		}
		
		session.setAttribute("class_set_id", classId);
		
		ClassEntity classInfo = service.getClassById(classId);
		
		List<ClassSubject> classSubjectsInfo = classSubjectService.getClassSubjectsByClassId(classId);
		
		ArrayList<Subject> subjectsInfo = new ArrayList<>();
		
		for (ClassSubject classSubject : classSubjectsInfo) {
			
			subjectsInfo.add(classSubject.getSubject());
			
			
		}
		
		ClassSetForm setForm = new ClassSetForm();
		
		setForm.setStartYear(classInfo.getStartYear());
		
		setForm.setMajorName(classInfo.getMajor().getName());
		
		redirectAttributes.addFlashAttribute("class_set_data", setForm);
		
		if (subjectsInfo != null) {
			
			redirectAttributes.addFlashAttribute("subject_all", subjectsInfo);
			
		}
		
		
		
		return "redirect:/manager/class_update_view";
		
		
	}

	/* クラス更新処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param form クラス更新フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/class_update")
	public String setClass(HttpSession session, RedirectAttributes redirectAttributes, ClassSetForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		Integer classId = (Integer)session.getAttribute("class_set_id");
		
		session.setAttribute("class_set_data", form);
		
		Integer startYear = (Integer)form.getStartYear();
		
		List<ClassEntity> classesCheckInfo = service.getClassesByStartYear(startYear);
		
		 
		
		long checkCount = classesCheckInfo.stream().
							filter(classInfo -> (form.getMajorName().equals(classInfo.getMajor().getName())) && (classId != classInfo.getId()))
								.count();
		
		
		
		if (checkCount > 0) {
			
			session.setAttribute("class_set_result", "既に存在するクラスです");
			
			return "redirect:/manager/class_update?id=" + classId;
			
		}
		
		
		Major majorInfo = service.getMajorByName(form.getMajorName());
		
		Integer majorId = (Integer)majorInfo.getId();
		
		ClassEntity classInfo = service.setClass(form, loginId, majorId, classId);
		
		// 該当教科登録処理
		
		List<String> subjectNames = List.of(
					form.getSubjectNameOne(),
					form.getSubjectNameTwo(),
					form.getSubjectNameThree(),
					form.getSubjectNameFour(),
					form.getSubjectNameFive(),
					form.getSubjectNameSix(),
					form.getSubjectNameSeven()
				)
				.stream()
					.filter(subjectName -> subjectName != null && subjectName != "")
						.toList();
					
				
		
		// 該当の授業クラスの教科一覧を取得し、一旦リセット
		
		List<ClassSubject> classSubjectsInfo = classSubjectService.getClassSubjectsByClassId(classId);
		
		
		for (ClassSubject classSubject : classSubjectsInfo) {
			
			Integer deleteId =  classSubject.getId();
			
			classSubjectService.deleteClassSubjectById(deleteId);
			
			
		}
		

		
		
		
		
		
		for (String subjectName : subjectNames) {
			
			
			ClassSubjectAddForm classSubjectAddForm = new ClassSubjectAddForm();
			
			Subject subjectInfo = subjectService.getSubjectByName(subjectName);
			
			Manager managerInfo = managerService.getManagerById(loginId);
			
			classSubjectAddForm.setClassId(classInfo.getId());
			
			classSubjectAddForm.setSubjectId(subjectInfo.getId());
			
			classSubjectAddForm.setManagerId(managerInfo.getId());
			
			
			ClassSubject classSubjectInfo = classSubjectService.setClassSubject(classSubjectAddForm);
			
			
			
		}
		
		
		
		
		
		session.setAttribute("class_info", classInfo);
		
		session.setAttribute("class_set_result", "クラス更新が完了しました");
		
		session.removeAttribute("class_set_data");
		
		session.removeAttribute("class_set_id");
	
		
		return "redirect:/manager/class?id=" + classInfo.getId();
		
		
		
		
	}
	
}
