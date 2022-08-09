package com.yoojung0318.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoojung0318.memo.post.bo.PostBO;

@RestController
public class PostRestController {

	@Autowired 
	PostBO postBO;
	//메모 입력 api
	@PostMapping("/post/create")
	public Map<String, String> memoCreate(
			@RequestParam("title")String title
			,@RequestParam("content")String content
			,HttpServletRequest request){ // session 얻어오기 위해 request 씀
		
		HttpSession session =request.getSession();
		
		int userId = (Integer)session.getAttribute("userId"); //다운캐스팅( object로 저장되어있기에, int로 바꿔줘야함)
	
		int count = postBO.addPost(userId, title, content);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
		
	}
	
}
