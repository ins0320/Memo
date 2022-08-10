package com.yoojung0318.memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoojung0318.memo.post.bo.PostBO;
import com.yoojung0318.memo.post.model.Post;

@Controller
public class PostController {

	@Autowired
	private PostBO postBO;
	// 메모 리스트 페이지
	@GetMapping("/post/list/view")
	public String postList(HttpServletRequest request, Model model) {
		//userRestController에서 저장한 session을 가져와서, 기반으로 테이블 조회
		HttpSession session = request.getSession();
		
		// 로그인한 사용자의 id 정보를 가져옴, int형으로 다운캐스팅
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postList = postBO.getPostList(userId);
		model.addAttribute("memoList", postList);
		
		return "post/list"; 
	}
	
	// 메모 입력 페이지
	@GetMapping("/post/create/view")
	public String postInput() {
		
		return "post/create";
	}
	
	// 메모 세부 페이지
	// jsp에서 데이터를 조회하려면 controller에서 조회해줘야함[중요]
	// post의 id를 전달박도, 해당하는 메모를 조회하여, model에 추가한다.
	@GetMapping("/post/detail/view")
	public String postDetail(@RequestParam("id")int id, Model model) {
		
		Post post = postBO.getPost(id);
		model.addAttribute("memo" , post);
		return "post/detail";
	}
}
