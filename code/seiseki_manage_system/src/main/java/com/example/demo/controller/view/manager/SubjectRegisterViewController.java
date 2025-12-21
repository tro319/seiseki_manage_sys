package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.form.manager.SubjectRegisterForm;

import lombok.RequiredArgsConstructor;

/* SubjectRegisterViewController クラス (教科登録フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectRegisterViewController {

	/* 教科登録フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject_register")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		SubjectRegisterForm subjectRegisterForm = (SubjectRegisterForm)session.getAttribute("subject_register_data");
		
		if (subjectRegisterForm == null) {
			
			subjectRegisterForm = new SubjectRegisterForm();
		
		}
		
		model.addAttribute("subject_register_data", subjectRegisterForm);
		
		return "manager/subject_register";
		
		
	}
	
}
