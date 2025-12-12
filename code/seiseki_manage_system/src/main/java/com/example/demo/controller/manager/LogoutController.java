package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

/* LogoutController クラス (ログアウト処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class LogoutController {
	
	

	/* ログアウト処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		session.removeAttribute("log_manager_id");
		
		session.removeAttribute("log_manager_name");
		
		session.setAttribute("logout_result", "ログアウトしました");
		
		return "redirect:/manager/login";
		
		
	}
	

}
