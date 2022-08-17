package com.yoojung0318.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yoojung0318.memo.post.bo.PostBO;

@RestController
//화면 구성 + api 생성
public class PostRestController {
//controller: 요청 주고 받는 역할만 함
	@Autowired 
	PostBO postBO;
	//메모 입력 api
	@PostMapping("/post/create")
	public Map<String, String> memoCreate(
			@RequestParam("title") String title
			,@RequestParam("content")String content
			,@RequestParam(value="file", required=false) MultipartFile  file// file의 타입, 필수 요소 아님을 나타냄(value="", required=false)
			,HttpServletRequest request){ // session 얻어오기 위해 request 씀
		
		HttpSession session =request.getSession();
		
		int userId = (Integer)session.getAttribute("userId"); //다운캐스팅( object로 저장되어있기에, int로 바꿔줘야함)
	
		int count = postBO.addPost(userId,title, content, file);//BO 메소드에서 전달받은 변수값 그대로
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
		
	}
	
}
