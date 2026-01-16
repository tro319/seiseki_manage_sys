package com.example.demo.controller.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.ClassSubject;
import com.example.demo.service.ClassService;
import com.example.demo.service.ClassSubjectService;

import lombok.RequiredArgsConstructor;

/* ClassGetController クラス (クラス取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassGetController {
	
	
	private final ClassService service;
	
	private final ClassSubjectService classSubjectService;

	/* クラス取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定されたクラスid
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/class")
	public String getClass(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam (required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		

		
		Integer classId = (Integer)id;
		
		ClassEntity classInfo = (ClassEntity)session.getAttribute("class_info");
		
		String setResult = (String)session.getAttribute("class_set_result");
		
		String registerResult = (String)session.getAttribute("class_register_result");
		
		List<ClassSubject> classSubjectsInfo = null;
		
		
		if (classInfo != null && registerResult != null) {
			
			redirectAttributes.addFlashAttribute("class_info", classInfo);
			
			redirectAttributes.addFlashAttribute("class_register_result", registerResult);
			
			session.removeAttribute("class_register_result");
			
		} else if (setResult != null) {
		
			redirectAttributes.addFlashAttribute("class_info", classInfo);
			
			redirectAttributes.addFlashAttribute("class_set_result", setResult);
			
			session.removeAttribute("class_set_result");
			
		
		} else {
			
			
			if (classId <= 0) {
				
				return "redirect:/manager/classes";
				
			}
			
			classInfo = service.getClassById(classId);
		
			

		}
		
		classSubjectsInfo = classSubjectService.getClassSubjectsByClassId(classId);
		
		redirectAttributes.addFlashAttribute("class_info", classInfo);
		
		if (classSubjectsInfo != null) {
			
			redirectAttributes.addFlashAttribute("class_subjects", classSubjectsInfo);
			
		}
		
		session.removeAttribute("class_info");
		
		
		session.setAttribute("class_get_id", classId);
		
		
		return "redirect:/manager/class_view";
		
		
		
		
	}
	
}
