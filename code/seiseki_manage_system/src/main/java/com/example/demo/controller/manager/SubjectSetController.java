package com.example.demo.controller.manager;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.SubjectSetForm;
import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* SubjectSetController クラス (教科更新処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectSetController {
	
	
	private final SubjectService service;

	/* 教科取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定された教科id
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject_update")
	public String getSubject(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/subjects";
			
		}
		
		Integer subjectId = (Integer)id;
		
		Subject subjectInfo = service.getSubjectById(subjectId);
		
		SubjectSetForm subjectSetForm = new SubjectSetForm();
		
		
		if (subjectInfo != null) {
			
			subjectSetForm.setName(subjectInfo.getName());
			
			subjectSetForm.setKana(subjectInfo.getKana());
			
		} else {
			
			return "redirect:/manager/subjects";
			
		}
		
		
		String setResult = (String)session.getAttribute("subject_set_result");
		
		session.removeAttribute("subject_set_result");
		
		if (setResult != null) {
			
			redirectAttributes.addFlashAttribute("subject_set_result", setResult);
			
		}
		
		
		redirectAttributes.addFlashAttribute("subject_set_data", subjectSetForm);
		
		redirectAttributes.addFlashAttribute("subject", subjectInfo);
		
		session.setAttribute("subject_set_id", subjectId);
		
		return "redirect:/manager/subject_update_view";
		
		
		
		
	}
	
	
	/* 教科更新処理
	 * 
	 * @param session セッション値情報
	 * @param form 教科更新フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/subject_update")
	public String setSubject(HttpSession session, SubjectSetForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		Integer subjectId = (Integer)session.getAttribute("subject_set_id");
		
		session.removeAttribute("subject_set_id");
		
		Subject subjectInfo = service.getSubjectById(subjectId);
		
		if (subjectInfo != null) {
			
			Map<String, String> updates = new HashMap<>();
			
			if (!subjectInfo.getName().equals(form.getName())) {
				
				updates.put("name", form.getName());
				
			}
			
			if (!subjectInfo.getKana().equals(form.getKana())) {
				
				updates.put("kana", form.getKana());
				
			}
			
			if (updates.size() == 0) {
				
				session.setAttribute("subject_set_result", "情報が更新されていません");
				
				return "redirect:/manager/subject_update?id=" + subjectInfo.getId();
				
			}
			
			subjectInfo = service.updateSubject(subjectId, updates, loginId);
			
			session.setAttribute("subject", subjectInfo);
			
			session.setAttribute("subject_set_result", "教科情報を更新しました");
			
		}
		
		
		return "redirect:/manager/subject?id=" + subjectInfo.getId();
		
		
		
		
	}
	
}
