package com.yoojung0318.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yoojung0318.memo.common.FileManagerService;
import com.yoojung0318.memo.post.dao.PostDAO;
import com.yoojung0318.memo.post.model.Post;

@Service
public class PostBO {

	@Autowired 
	PostDAO postDAO;
	//userId,제목, 내용 저장 기능
	public int addPost(int userId, String title, String content, MultipartFile file) {
		
		//파일을 저장한다.
		//해당 파일을 외부에서 접근할 수 있는 경로를 만들어서 dao로 전달한다.(DB에 저장하기 위해)
		String imagePath = FileManagerService.saveFile(userId, file); //외부에서 접근가능한 경로
		
	return 	postDAO.insertPost(userId, title, content, imagePath);
	}
	
	//userId가 일치하는 메모 리스트 조회
	public List<Post> getPostList(int userId){
		return postDAO.selectPostList(userId);
	}
	// id 일치하는 메모 조회  
	// id 값 하나만 전달되니까 type: post
	public Post getPost(int id){
		return postDAO.selectPost(id);
	}
}
