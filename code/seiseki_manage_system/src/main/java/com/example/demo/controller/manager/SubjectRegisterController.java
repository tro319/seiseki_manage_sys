package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.SubjectRegisterForm;
import com.example.demo.service.manager.SubjectService;

import lombok.RequiredArgsConstructor;

/* SubjectRegisterController クラス (教科登録処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectRegisterController {
	
	
	private final SubjectService service;

	/* 教科登録処理
	 * 
	 * @param session セッション値情報
	 * @param form 教科登録フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/subject_register")
	public String registerSubject(HttpSession session, RedirectAttributes redirectAttributes, SubjectRegisterForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		session.setAttribute("subject_register_data", form);
		
		String subjectName = form.getName();
		
		Boolean doubleCheck = service.checkDouble(subjectName);
		
		if (doubleCheck) {
			
			redirectAttributes.addFlashAttribute("subject_register_result", "既に存在する教科です");
			
			return "redirect:/manager/subject_register";
			
		}
		
		Subject subjectInfo = service.registerSubject(form, loginId);
		
		session.setAttribute("subject", subjectInfo);
		
		session.setAttribute("subject_register_result", "教科登録が完了しました");
		
		return "redirect:/manager/subject?id=" + subjectInfo.getId();
		
		
		
		
	}
	
}
