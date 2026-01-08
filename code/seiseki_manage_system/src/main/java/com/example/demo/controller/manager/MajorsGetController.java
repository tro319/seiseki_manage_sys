package com.example.demo.controller.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Major;
import com.example.demo.service.MajorService;

import lombok.RequiredArgsConstructor;

/* MajorsGetController クラス (専攻一覧取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorsGetController {
	
	
	private final MajorService service;

	/* 専攻一覧取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/majors")
	public String getMajors(HttpSession session, RedirectAttributes redirectAttributes) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}

		
		List<Major> majorsInfo = service.getMajors();
		
		String deleteResult = (String)session.getAttribute("major_delete_result");
		
		if (deleteResult != null) {
			
			redirectAttributes.addFlashAttribute("major_delete_result", deleteResult);
			
			session.removeAttribute("major_delete_result");
			
		}
		
		redirectAttributes.addFlashAttribute("majors", majorsInfo);
		
		return "redirect:/manager/majors_view";
		
		
		
		
	}
	
}
