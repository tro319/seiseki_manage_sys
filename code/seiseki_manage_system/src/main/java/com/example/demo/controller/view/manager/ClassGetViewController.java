package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* ClassGetViewController クラス (クラス表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassGetViewController {

	/* クラス表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_view")
	public String classView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("class_info")) {
			
			Integer classId = (Integer)session.getAttribute("class_get_id");
			
			session.removeAttribute("class_get_id");
			
			if (classId > 0) {
				
				return "redirect:/manager/class?id=" + classId;
				
			}
			
			return "redirect:/manager/classes";
			
		}
		
		return "manager/class";
		
		
	}
	
}
