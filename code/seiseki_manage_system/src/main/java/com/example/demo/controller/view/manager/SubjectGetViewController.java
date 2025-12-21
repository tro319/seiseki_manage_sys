package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* SubjectGetViewController クラス (教科表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectGetViewController {

	/* 教科表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject_view")
	public String subjectView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("subject")) {
			
			Integer subjectId = (Integer)session.getAttribute("subject_get_id");
			
			session.removeAttribute("subject_get_id");
			
			if (subjectId > 0) {
				
				return "redirect:/manager/subject?id=" + subjectId;
				
			}
			
			return "redirect:/manager/subjects";
			
		}
		
		return "manager/subject";
		
		
	}
	
}
