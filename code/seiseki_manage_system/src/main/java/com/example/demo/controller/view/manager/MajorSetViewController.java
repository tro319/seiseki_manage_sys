package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* MajorSetViewController クラス (専攻更新フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorSetViewController {

	/* 専攻更新フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/major_update_view")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("major_set_data")) {
			
			Integer majorId = (Integer)session.getAttribute("major_set_id");
		
			
			if (majorId > 0) {
				
				return "redirect:/manager/major_update?id=" + majorId;
				
			}
			
			return "redirect:/manager/majors";
			
		}
		
		return "manager/major_set";
		
		
	}
	
}
