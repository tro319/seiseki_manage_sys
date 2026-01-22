package com.example.demo.controller.view.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.entity.Major;
import com.example.demo.model.entity.Subject;
import com.example.demo.service.MajorService;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* ClassSetViewController クラス (クラス更新フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassSetViewController {
	
	private final MajorService majorService;
	
	private final SubjectService subjectService;

	/* クラス更新フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_update_view")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		if (!model.containsAttribute("class_set_data")) {
			
			Integer classId = (Integer)session.getAttribute("class_set_id");

				
			if (classId > 0) {
				
				return "redirect:/manager/class_update?id=" + classId;
				
			}
			
			return "redirect:/manager/classes";
			
			
		}
		

		List<Major> majorAll = majorService.getMajors();
		
		List<Subject> subjectAll = subjectService.getSubjects();
		
		model.addAttribute("major_all", majorAll);
		
		model.addAttribute("subject_all", subjectAll);
		
		return "manager/class_set";
		
		
	}
	
}
