package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* SubjectsGetViewController クラス (教科一覧表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectsGetViewController {

	/* 教科一覧表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/subjects_view")
	public String subjectsView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("subjects")) {
			
			return "redirect:/manager/subjects";
			
		}
		
		
		return "manager/subjects";
		
		
	}
	
	
}
