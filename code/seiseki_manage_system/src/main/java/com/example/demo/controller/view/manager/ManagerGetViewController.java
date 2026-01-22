package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* ManagerGetViewController クラス (管理者表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ManagerGetViewController {

	/* 管理者表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/manager_view")
	public String managerView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("manager")) {

			
			return "redirect:/manager/manager_get";
			
			
		}
		
		return "manager/manager";
		
		
	}
	
}
