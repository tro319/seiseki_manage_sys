package com.example.demo.controller.view.manager;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class loginResultTest {
	
	
	@GetMapping("manager/majors")
	
	public String testView(HttpSession session) {
		
		Integer loginId = (Integer)session.getAttribute("log_manager_id");
		
		// ログインしているか
		
		if (loginId == null) {
			
			return "redirect:/manager/login";
			
		}
		
		
		session.removeAttribute("login_result");
		
		
		return "majors";
		
		
		
	}
	
}
