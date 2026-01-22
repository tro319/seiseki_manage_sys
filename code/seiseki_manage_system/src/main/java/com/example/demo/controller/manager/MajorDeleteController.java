package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.MajorService;

import lombok.RequiredArgsConstructor;

/* MajorDeleteController クラス (専攻削除処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorDeleteController {
	
	
	private final MajorService service;

	/* 専攻削除処理
	 * 
	 * @param session セッション値情報
	 * @param id リクエストパラムで指定された専攻id
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/major_delete")
	public String deleteMajor(HttpSession session, @RequestParam int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/majors";
			
		}
		
		
		Integer majorId = (Integer)id;

		
		service.deleteMajor(majorId);
		
		session.setAttribute("major_delete_result", "専攻を削除しました");
		
		
		return "redirect:/manager/majors";
		
		
		
		
	}
	
}
