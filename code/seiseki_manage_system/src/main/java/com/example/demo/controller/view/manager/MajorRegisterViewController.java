package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.form.manager.MajorRegisterForm;

import lombok.RequiredArgsConstructor;

/* MajorRegisterViewController クラス (専攻登録フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorRegisterViewController {

	/* 専攻登録フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/major_register")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		MajorRegisterForm majorRegisterForm = (MajorRegisterForm)session.getAttribute("major_register_data");
		
		if (majorRegisterForm == null) {
			
			majorRegisterForm = new MajorRegisterForm();
		
		}
		
		model.addAttribute("major_register_data", majorRegisterForm);
		
		return "manager/major_register";
		
		
	}
	
}
