package com.example.demo.controller.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.service.manager.ClassService;

import lombok.RequiredArgsConstructor;

/* ClassesGetController クラス (クラス一覧取得処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassesGetController {
	
	
	private final ClassService service;

	/* クラス一覧取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/classes")
	public String getClasses(HttpSession session, RedirectAttributes redirectAttributes) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}

		
		List<ClassEntity> classesInfo = service.getClasses();
		
		String deleteResult = (String)session.getAttribute("class_delete_result");
		
		if (deleteResult != null) {
			
			redirectAttributes.addFlashAttribute("class_delete_result", deleteResult);
			
			session.removeAttribute("class_delete_result");
			
		}
		
		redirectAttributes.addFlashAttribute("classes", classesInfo);
		
		return "redirect:/manager/classes_view";
		
		
		
		
	}
	
}
