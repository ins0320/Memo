package com.yoojung0318.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yoojung0318.memo.post.model.Post;

public interface PostDAO {
// 전달받은 데이터들을, DB에서 사용가능하게 만들어줌
	public int insertPost(
			@Param("userId") int userid
			,@Param("title") String title
			,@Param("content") String content
			,@Param("imagePath")String imagePath);

	
	public List<Post> selectPostList(@Param("userId") int userId);

	public Post selectPost(@Param("id") int id);
}