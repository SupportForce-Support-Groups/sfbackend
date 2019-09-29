package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.dao.SupportGroupDao;
import com.project.dao.SupportGroupDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.Post;
import com.project.model.SupportGroup;
import com.project.model.User;

@Transactional
@Service("postServ")
public class PostServiceImpl implements PostService {

	private PostDao postDao = new PostDaoImpl();
	private SupportGroupDao sgDao = new SupportGroupDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	
	public PostServiceImpl() {
		
	}
	
	@Autowired
	public PostServiceImpl(PostDaoImpl postDao, SupportGroupDaoImpl sgDao, UserDaoImpl userDao) {
		this.postDao = postDao;
		this.sgDao = sgDao;
		this.userDao = userDao;
	}
	
	
	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	//This method will create a post object in the database table.
	@Override
	public Post creationPost(String postBody , int supportGrpId, int userId) {

		Post post = new Post(postBody);

		postDao.insert(post);
		
		SupportGroup supportGroup = sgDao.selectById(supportGrpId);
		supportGroup.getPostList().add(post);
		
		User user = userDao.selectById(userId);
		user.getPosts().add(post);
		
		return post;

	}
	
	@Override
	public List<Post> listOfPostForSupportGroup(int sgId) {
		SupportGroup supportGrp = sgDao.selectById(sgId);
		List<Post> postList = supportGrp.getPostList();
		
		return postList;
		
	}


}
