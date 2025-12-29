package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* ClassesGetViewController クラス (クラス一覧表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassesGetViewController {

	/* クラス一覧表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/classes_view")
	public String classesView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("classes")) {
			
			return "redirect:/manager/classes";
			
		}
		
		
		return "manager/classes";
		
		
	}
	
	
}
