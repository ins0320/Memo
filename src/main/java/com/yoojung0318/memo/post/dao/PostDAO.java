package com.yoojung0318.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yoojung0318.memo.post.model.Post;

public interface PostDAO {

	public int insertPost(
			@Param("userId") int userid
			,@Param("title") String title
			,@Param("content") String content);

	
	public List<Post> selectPostList(@Param("userId") int userId);

	public Post selectPost(@Param("id") int id);
}