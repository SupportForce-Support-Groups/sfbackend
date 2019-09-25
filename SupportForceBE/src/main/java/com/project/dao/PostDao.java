package com.project.dao;

import java.util.List;

import com.project.model.Post;

public interface PostDao {
	
	public void insert(Post myPost);
	
	public List<Post> selectAllPosts();
	
	public Post selectById(int postId);

}
