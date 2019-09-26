package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.model.Post;

@Transactional
@Service("postServ")
public class PostServiceImpl implements PostService {

	private static PostDao postDao = new PostDaoImpl();
	
	public PostServiceImpl() {
		
	}
	
	@Autowired
	public PostServiceImpl(PostDaoImpl postDao) {
		this.postDao = postDao;
	}
	
	
	public static PostDao getPostDao() {
		return postDao;
	}

	public static void setPostDao(PostDao postDao) {
		PostServiceImpl.postDao = postDao;
	}

	//This method will create a post object in the database table.
	public Post creationPost(String postBody) {

		Post post = new Post(postBody);

		postDao.insert(post);

		return post;

	}


}
