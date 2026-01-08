package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Subject;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* SubjectGetController クラス (教科取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectGetController {
	
	
	private final SubjectService service;

	/* 教科取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定された教科id
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject")
	public String getSubject(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam (required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		

		
		Integer subjectId = (Integer)id;
		
		Subject subjectInfo = (Subject)session.getAttribute("subject");
		
		String setResult = (String)session.getAttribute("subject_set_result");
		
		String registerResult = (String)session.getAttribute("subject_register_result");
		
		
		if (subjectInfo != null && registerResult != null) {
			
			redirectAttributes.addFlashAttribute("subject", subjectInfo);
			
			redirectAttributes.addFlashAttribute("subject_register_result", registerResult);
			
			session.removeAttribute("subject_register_result");
			
		} else if (setResult != null) {
		
			redirectAttributes.addFlashAttribute("subject", subjectInfo);
			
			redirectAttributes.addFlashAttribute("subject_set_result", setResult);
			
			session.removeAttribute("subject_set_result");
			
		
		} else {
			
			
			if (subjectId <= 0) {
				
				return "redirect:/manager/subjects";
				
			}
			
			subjectInfo = service.getSubjectById(subjectId);
			
			redirectAttributes.addFlashAttribute("subject", subjectInfo);
			
			
		}
		
		session.removeAttribute("subject");
		
		
		session.setAttribute("subject_get_id", subjectId);
		
		
		return "redirect:/manager/subject_view";
		
		
		
		
	}
	
}
