package com.example.demo.controller.view.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.entity.Major;
import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.ClassRegisterForm;
import com.example.demo.service.MajorService;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* ClassRegisterViewController クラス (クラス登録フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassRegisterViewController {
	
	private final MajorService majorService;
	
	private final SubjectService subjectService;

	/* クラス登録フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_register")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		ClassRegisterForm classRegisterForm = (ClassRegisterForm)session.getAttribute("class_register_data");
		
		if (classRegisterForm == null) {
			
			classRegisterForm = new ClassRegisterForm();
		
		}
		
		List<Major> majorAll = majorService.getMajors();
		
		List<Subject> subjectAll = subjectService.getSubjects();
		
		model.addAttribute("major_all", majorAll);
		
		model.addAttribute("subject_all", subjectAll);
		
		model.addAttribute("class_register_data", classRegisterForm);
		
		return "manager/class_register";
		
		
	}
	
}
