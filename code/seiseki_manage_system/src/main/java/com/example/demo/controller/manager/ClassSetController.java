package com.example.demo.controller.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.Major;
import com.example.demo.model.form.manager.ClassSetForm;
import com.example.demo.service.manager.ClassService;

import lombok.RequiredArgsConstructor;

/* ClassSetController クラス (クラス更新処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassSetController {
	
	
	private final ClassService service;

	/* クラス取得処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param id リクエストパラムで指定されたクラスid
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@GetMapping("/manager/class_update")
	public String getClass(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(required=false) int id) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		if (id <= 0) {
			
			return "redirect:/manager/classes";
			
		}
		
		Integer classId = (Integer)id;
		
		ClassEntity classInfo = service.getClassById(classId);
		
		ClassSetForm classSetForm = new ClassSetForm();
		
		
		if (classInfo != null) {
			
			classSetForm.setStartYear(classInfo.getStartYear());
			
			classSetForm.setMajorName(classInfo.getMajor().getName());
			
			
		} else {
			
			return "redirect:/manager/classes";
			
		}
		
		
		String setResult = (String)session.getAttribute("class_set_result");
		
		session.removeAttribute("class_set_result");
		
		if (setResult != null) {
			
			redirectAttributes.addFlashAttribute("class_set_result", setResult);
			
		}
		
		// フォーム選択のため、専攻一覧取得
		
		List<Major> majorsInfo = service.getMajors();
		
		redirectAttributes.addFlashAttribute("major_all", majorsInfo);
		
		
		redirectAttributes.addFlashAttribute("class_set_data", classSetForm);
		
		redirectAttributes.addFlashAttribute("class_info", classInfo);
		
		session.setAttribute("class_set_id", classId);
		
		return "redirect:/manager/class_update_view";
		
		
		
		
	}
	
	
	/* クラス更新処理
	 * 
	 * @param session セッション値情報
	 * @param form クラス更新フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/class_update")
	public String setClass(HttpSession session, ClassSetForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		Integer classId = (Integer)session.getAttribute("class_set_id");
		
		session.removeAttribute("class_set_id");
		
		ClassEntity classInfo = service.getClassById(classId);
		
		if (classInfo != null) {
			
			Map<String, String> updates = new HashMap<>();
			
			if (classInfo.getStartYear() != form.getStartYear()) {
				
				String startYear = Integer.toString(form.getStartYear());
				
				updates.put("start_year", startYear);
				
			}
			
			if (!classInfo.getMajor().getName().equals(form.getMajorName())) {
				
				updates.put("major_name", form.getMajorName());
				
			}
			
			if (updates.size() == 0) {
				
				session.setAttribute("class_set_result", "情報が更新されていません");
				
				return "redirect:/manager/class_update?id=" + classInfo.getId();
				
			}
			
			classInfo = service.updateClass(classId, updates, loginId);
			
			session.setAttribute("class_info", classInfo);
			
			session.setAttribute("class_set_result", "クラス情報を更新しました");
			
		}
		
		
		return "redirect:/manager/class?id=" + classInfo.getId();
		
		
		
		
	}
	
}
