package com.example.demo.controller.manager;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Major;
import com.example.demo.model.form.manager.MajorSetForm;
import com.example.demo.service.manager.MajorService;

import lombok.RequiredArgsConstructor;

/* MajorSetController クラス (専攻更新処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class MajorSetController {
	
	
	private final MajorService service;

	/* 専攻取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定された専攻id
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/major_update")
	public String getMajor(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/majors";
			
		}
		
		Integer majorId = (Integer)id;
		
		Major majorInfo = service.getMajor(majorId);
		
		MajorSetForm majorSetForm = new MajorSetForm();
		
		
		if (majorInfo != null) {
			
			majorSetForm.setName(majorInfo.getName());
			
			majorSetForm.setKana(majorInfo.getKana());
			
		} else {
			
			return "redirect:/manager/majors";
			
		}
		
		
		String setResult = (String)session.getAttribute("major_set_result");
		
		session.removeAttribute("major_set_result");
		
		if (setResult != null) {
			
			redirectAttributes.addFlashAttribute("major_set_result", setResult);
			
		}
		
		
		redirectAttributes.addFlashAttribute("major_set_data", majorSetForm);
		
		redirectAttributes.addFlashAttribute("major", majorInfo);
		
		session.setAttribute("major_set_id", majorId);
		
		return "redirect:/manager/major_update_view";
		
		
		
		
	}
	
	
	/* 専攻更新処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param form 専攻更新フォーム入力情報
	 * @param id リクエストパラムで指定された専攻id
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/major_update")
	public String setMajor(HttpSession session, RedirectAttributes redirectAttributes, MajorSetForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		Integer majorId = (Integer)session.getAttribute("major_set_id");
		
		session.removeAttribute("major_set_id");
		
		Major majorInfo = service.getMajor(majorId);
		
		if (majorInfo != null) {
			
			Map<String, String> updates = new HashMap<>();
			
			if (!majorInfo.getName().equals(form.getName())) {
				
				updates.put("name", form.getName());
				
			}
			
			if (!majorInfo.getKana().equals(form.getKana())) {
				
				updates.put("kana", form.getKana());
				
			}
			
			if (updates.size() == 0) {
				
				session.setAttribute("major_set_result", "情報が更新されていません");
				
				return "redirect:/manager/major_update?id=" + majorInfo.getId();
				
			}
			
			majorInfo = service.updateMajor(majorId, updates);
			
			session.setAttribute("major", majorInfo);
			
			session.setAttribute("major_set_result", "専攻情報を更新しました");
			
		}
		
		
		return "redirect:/manager/major?id=" + majorInfo.getId();
		
		
		
		
	}
	
}
