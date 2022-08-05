package com.yoojung0318.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoojung0318.memo.user.bo.UserBO;
import com.yoojung0318.memo.user.model.User;

@RestController//@Controller + @ResponseBody
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	// 회원 가입 api
	@PostMapping("/user/signup")
	public Map<String, String> signUp(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email) {
		
		int count = userBO.addUser(loginId, password, name, email);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	@PostMapping("/user/signin")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<>();
		// 아이디와 패스워드 전달 받고,
		// 일치하는 데이터가 있는지 확인 
		User user = userBO.getUser(loginId, password);
		
		// 세션을 통해서 로그인 상태를 만들어 준다.
		// 로그인 성공 - 아이디 패스워드 일치
		if(user != null) {
			map.put("result", "success");
			
			HttpSession session = request.getSession();
			// userId, loginId, name
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
		} else {
			map.put("retult", "fail");
		}
		
		return map;
		
		}
	}


