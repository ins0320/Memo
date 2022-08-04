package com.yoojung0318.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	//jsp 화면 구성 
	@GetMapping("/user/signup/view")
	public String signupView() {
		return "user/signup";
	}


	@GetMapping("/user/signin/view")
	public String signinView() {
		return "user/signin";
	}
}
