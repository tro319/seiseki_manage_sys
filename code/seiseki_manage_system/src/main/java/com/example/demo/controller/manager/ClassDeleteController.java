package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ClassService;

import lombok.RequiredArgsConstructor;

/* ClassDeleteController クラス (クラス削除処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassDeleteController {
	
	
	private final ClassService service;

	/* クラス削除処理
	 * 
	 * @param session セッション値情報
	 * @param id リクエストパラムで指定されたクラスid
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_delete")
	public String deleteClass(HttpSession session, @RequestParam int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/classes";
			
		}
		
		
		Integer classId = (Integer)id;

		
		service.deleteClass(classId);
		
		session.setAttribute("class_delete_result", "クラスを削除しました");
		
		
		return "redirect:/manager/classes";
		
		
		
		
	}
	
}
