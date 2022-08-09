package com.yoojung0318.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	//메모 리스트 페이지
	@GetMapping("/post/list/view")
	public String postList() {
		
		return "post/list"; 
	}
	
	//메모 입력 페이지
	@GetMapping("/post/create/view")
	public String postInput() {
		
		return "post/create";
	}
}
