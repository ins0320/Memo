package com.yoojung0318.memo.post.dao;

import org.apache.ibatis.annotations.Param;

public interface PostDAO {

	public int insertPost(
			@Param("userId") int userid
			,@Param("title") String title
			,@Param("content") String content);
}
