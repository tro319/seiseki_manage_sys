package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* SubjectSetViewController クラス (教科更新フォーム表示へ コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectSetViewController {

	/* 教科更新フォーム表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当htmlへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject_update_view")
	public String formView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (!model.containsAttribute("subject_set_data")) {
			
			Integer subjectId = (Integer)session.getAttribute("subject_set_id");
		
			
			if (subjectId > 0) {
				
				return "redirect:/manager/subject_update?id=" + subjectId;
				
			}
			
			return "redirect:/manager/subjects";
			
		}
		
		return "manager/subject_set";
		
		
	}
	
}
