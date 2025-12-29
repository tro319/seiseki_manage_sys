package com.example.demo.controller.manager;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.Major;
import com.example.demo.model.form.manager.ClassRegisterForm;
import com.example.demo.service.manager.ClassService;

import lombok.RequiredArgsConstructor;

/* ClassRegisterController クラス (クラス登録処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class ClassRegisterController {
	
	
	private final ClassService service;

	/* クラス登録処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param form クラス登録フォーム入力情報
	 * @return 該当Controllerクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/class_register")
	public String registerClass(HttpSession session, RedirectAttributes redirectAttributes, ClassRegisterForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		session.setAttribute("class_register_data", form);
		
		Integer startYear = (Integer)form.getStartYear();
		
		List<ClassEntity> classesCheckInfo = service.getClassesByStartYear(startYear);
		
		 
		
		long checkCount = classesCheckInfo.stream().
							filter(classInfo -> form.getMajorName().equals(classInfo.getMajor().getName()))
								.count();
		
		
		
		if (checkCount > 0) {
			
			redirectAttributes.addFlashAttribute("class_register_result", "既に存在するクラスです");
			
			return "redirect:/manager/class_register";
			
		}
		
		
		Major majorInfo = service.getMajorByName(form.getMajorName());
		
		Integer majorId = (Integer)majorInfo.getId();
		
		ClassEntity classInfo = service.registerClass(form, loginId, majorId);
		
		session.setAttribute("class_info", classInfo);
		
		session.setAttribute("class_register_result", "クラス登録が完了しました");
		
		session.removeAttribute("class_register_data");
	
		
		return "redirect:/manager/class?id=" + classInfo.getId();
		
		
		
		
	}
	
}
