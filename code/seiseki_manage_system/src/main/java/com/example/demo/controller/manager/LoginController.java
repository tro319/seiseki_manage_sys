package com.example.demo.controller.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.entity.Manager;
import com.example.demo.model.form.LoginForm;
import com.example.demo.service.manager.ManagerService;

import lombok.RequiredArgsConstructor;

/* LoginController クラス (ログイン処理コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class LoginController {
	
	
	private final PasswordEncoder passEncoder;
	
	private final ManagerService service;
	

	/* ログイン処理
	 * 
	 * @param session セッション値情報
	 * @param redirectAttributes リダイレクト値情報
	 * @param フォーム フォームからの入力情報
	 * @return 該当viewクラスへのパス
	 * 
	 */
	
	@PostMapping("/manager/login")
	public String login(HttpSession session, RedirectAttributes redirectAttributes, LoginForm form) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		// ログインしているか
		
		if (loginId != null) {
			
			return "redirect:/manager/majors";
			
		}
		
		
		
		// フォーム入力情報を、セッション値にセット
		
		session.setAttribute("manager_login_data", form);
		
		
		String email = form.getEmail();
		
		// emailに紐づくエンティティを取得
		
		Manager managerInfo = service.getManagerByEmail(email);
		
		
		// エンティティがあったかどうか
		
		if (managerInfo != null) {
			
			if (passEncoder.matches(form.getPass(), managerInfo.getPass())) {
				
				session.setAttribute("login_result", "ログインしました！");
				
				session.setAttribute("log_manager_id", managerInfo.getId());
				
				session.setAttribute("log_manager_name", managerInfo.getName());
				
				session.removeAttribute("manager_login_data");
			
				
				return "redirect:/manager/majors";
				
			}
			
			
			// パスワードが一致しなければ
			
			session.setAttribute("login_result", "パスワードが、間違っています。");
			
			
		} else {
			
			
			// エンティティがなければ
			
			session.setAttribute("login_result", "メールアドレスが、間違っています。");
			
			
		}
		
		
		return "redirect:/manager/login";
		
		
	}
	
}

