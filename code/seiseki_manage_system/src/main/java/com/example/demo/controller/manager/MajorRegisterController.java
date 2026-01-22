package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Major;
import com.example.demo.model.form.manager.MajorRegisterForm;
import com.example.demo.service.MajorService;

import lombok.RequiredArgsConstructor;

/* MajorRegisterController クラス (専攻登録処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorRegisterController {
	
	
	private final MajorService service;

	/* 専攻登録処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param form 専攻登録フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/major_register")
	public String registerMajor(HttpSession session, RedirectAttributes redirectAttributes, MajorRegisterForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		session.setAttribute("major_register_data", form);
		
		String majorName = form.getName();
		
		Boolean doubleCheck = service.checkDouble(majorName);
		
		if (doubleCheck) {
			
			redirectAttributes.addFlashAttribute("major_register_result", "既に存在する専攻です");
			
			return "redirect:/manager/major_register";
			
		}
		
		Major majorInfo = service.registerMajor(form, loginId);
		
		session.setAttribute("major", majorInfo);
		
		session.setAttribute("major_register_result", "専攻登録が完了しました");
		
		session.removeAttribute("major_register_data");
		
		return "redirect:/manager/major?id=" + majorInfo.getId();
		
		
		
		
	}
	
}
