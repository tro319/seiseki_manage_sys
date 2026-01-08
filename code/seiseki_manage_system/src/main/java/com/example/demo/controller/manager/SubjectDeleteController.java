package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.SubjectService;

import lombok.RequiredArgsConstructor;

/* SubjectDeleteController クラス (教科削除処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class SubjectDeleteController {
	
	
	private final SubjectService service;

	/* 教科削除処理
	 * 
	 * @param session セッション値情報
	 * @param id リクエストパラムで指定された教科id
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/subject_delete")
	public String deleteSubject(HttpSession session, @RequestParam (required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/subjects";
			
		}
		
		
		Integer subjectId = (Integer)id;

		
		service.deleteSubject(subjectId);
		
		session.setAttribute("subject_delete_result", "教科を削除しました");
		
		
		return "redirect:/manager/subjects";
		
		
	}
	
}
