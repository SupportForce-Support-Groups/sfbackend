package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.dao.SupportGroupDao;
import com.project.dao.SupportGroupDaoImpl;
import com.project.model.Post;
import com.project.model.SupportGroup;

@Transactional
@Service("postServ")
public class PostServiceImpl implements PostService {

	private static PostDao postDao = new PostDaoImpl();
	private static SupportGroupDao sgDao = new SupportGroupDaoImpl();
	
	public PostServiceImpl() {
		
	}
	
	@Autowired
	public PostServiceImpl(PostDaoImpl postDao, SupportGroupDaoImpl sgDao) {
		this.postDao = postDao;
		this.sgDao = sgDao;
	}
	
	
	public static PostDao getPostDao() {
		return postDao;
	}

	public static void setPostDao(PostDao postDao) {
		PostServiceImpl.postDao = postDao;
	}

	//This method will create a post object in the database table.
	public Post creationPost(String postBody/* , int supportGrpId, int userId */) {

		Post post = new Post(postBody);

		postDao.insert(post);
		return post;
		
		/* SupportGroup supportGroup = sgDao.selectById(supportGrpId); */
		/* supportGroup.getPostList().add(post); */

	}


}
