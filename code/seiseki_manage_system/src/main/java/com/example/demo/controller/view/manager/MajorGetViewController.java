package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* MajorGetViewController クラス (専攻表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorGetViewController {

	/* 専攻表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/major_view")
	public String majorView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (model.getAttribute("major") == null) {
			
			Integer majorId = (Integer)session.getAttribute("major_get_id");
			
			session.removeAttribute("major_get_id");
			
			if (majorId > 0) {
				
				return "redirect:/manager/major?id=" + majorId;
				
			}
			
			return "redirect:/manager/majors";
			
		}
		
		return "manager/major";
		
		
	}
	
}
