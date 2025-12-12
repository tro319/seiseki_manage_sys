package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.form.LoginForm;

import lombok.RequiredArgsConstructor;

/* LoginViewController クラス (ログイン表示コントローラークラス)
 * 
 * @author ys
 * 
 */

@Controller
@RequiredArgsConstructor

public class LoginViewController {
	
	

	/* ログイン画面表示処理
	 * 
	 * @param session セッション値情報
	 * @param model モデル値情報
	 * @return 該当テンプレートへのパス
	 * 
	 */
	
	@GetMapping("/manager/login")
	public String loginView(HttpSession session, Model model) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		// ログインしているか
		
		if (loginId != null) {
			
			return "redirect:/manager/majors";
			
		}
		
		
		// フォーム入力情報取得
		
		LoginForm loginForm = (LoginForm)session.getAttribute("manager_login_data");
		
		String loginResult = (String)session.getAttribute("login_result");
		
		// 既存入力情報があるかどうか
		
		if (loginForm != null) {
			
			model.addAttribute("manager_login_data", loginForm);
			
		} else {
			
			loginForm = new LoginForm();
			
			model.addAttribute("manager_login_data", loginForm);
			
		}
		
		
		// ログインエラーメッセージがあるかどうか
		
		if (loginResult != null) {
			
			model.addAttribute("login_result", loginResult);
			
			
		}
		
		
		// ログアウト直後かどうか
		
		
		String logoutResult = (String)session.getAttribute("logout_result");
		
		
		if (logoutResult != null) {
			
			model.addAttribute("logout_result", logoutResult);
			
			
		}

		
		
		return "manager/login";
		
		
	}
	
}

