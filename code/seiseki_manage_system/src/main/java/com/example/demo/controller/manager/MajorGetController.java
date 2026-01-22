package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Major;
import com.example.demo.service.MajorService;

import lombok.RequiredArgsConstructor;

/* MajorGetController クラス (専攻取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorGetController {
	
	
	private final MajorService service;

	/* 専攻取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定された専攻id
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/major")
	public String getMajor(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		

		
		Integer majorId = (Integer)id;
		
		Major majorInfo = (Major)session.getAttribute("major");
		
		String setResult = (String)session.getAttribute("major_set_result");
		
		String registerResult = (String)session.getAttribute("major_register_result");
		
		
		if (majorInfo != null && registerResult != null) {
			
			redirectAttributes.addFlashAttribute("major", majorInfo);
			
			redirectAttributes.addFlashAttribute("major_register_result", registerResult);
			
			session.removeAttribute("major_register_result");
			
		} else if (setResult != null) {
		
			redirectAttributes.addFlashAttribute("major", majorInfo);
			
			redirectAttributes.addFlashAttribute("major_set_result", setResult);
			
			session.removeAttribute("major_set_result");
			
		
		} else {
			
			
			if (majorId <= 0) {
				
				return "redirect:/manager/majors";
				
			}
			
			majorInfo = service.getMajor(majorId);
			
			redirectAttributes.addFlashAttribute("major", majorInfo);
			
			
		}
		
		session.removeAttribute("major");
		
		
		session.setAttribute("major_get_id", majorId);
		
		
		return "redirect:/manager/major_view";
		
		
		
		
	}
	
}
