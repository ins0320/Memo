package com.yoojung0318.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	//jsp 화면 구성 
	@GetMapping("/user/signup/view")
	public String singupView() {
		return "user/signup";			
	}
	
	@GetMapping("/user/signin/view")
	public String signinView() {
		return "user/signin";
	}
	@GetMapping("/user/signout")
	public String signOut(HttpServletRequest request) {
		
		//로그아웃
		//로그인 시에 저장한 세션의 값들을 모두 제거한다.
		HttpSession session = request.getSession();	
		//userId, userLoginId, userName
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		//다른 페이지로 이동 
		//리다이렉트
		return "redirect:/user/signin/view";
	}
}
