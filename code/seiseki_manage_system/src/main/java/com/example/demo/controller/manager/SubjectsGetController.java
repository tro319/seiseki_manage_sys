package com.example.demo.controller.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Subject;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* SubjectsGetController クラス (教科一覧取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectsGetController {
	
	
	private final SubjectService service;

	/* 教科一覧取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/subjects")
	public String getSubjects(HttpSession session, RedirectAttributes redirectAttributes) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}

		
		List<Subject> subjectsInfo = service.getSubjects();
		
		String deleteResult = (String)session.getAttribute("subject_delete_result");
		
		if (deleteResult != null) {
			
			redirectAttributes.addFlashAttribute("subject_delete_result", deleteResult);
			
			session.removeAttribute("subject_delete_result");
			
		}
		
		redirectAttributes.addFlashAttribute("subjects", subjectsInfo);
		
		return "redirect:/manager/subjects_view";
		
		
		
		
	}
	
}
