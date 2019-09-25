package com.project.service;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.model.Post;

public class PostServiceImpl implements PostService {

	private static PostDao postDao = new PostDaoImpl();
	
	//This method will create a post object in the database table.
	public Post creationPost(String postBody) {

		Post post = new Post(postBody);

		postDao.insert(post);

		return post;

	}


}
