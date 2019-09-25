package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Post;
import com.project.util.HibernateUtil;

public class PostDaoImpl implements PostDao {
	
	@Override
	public void insert(Post myPost) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myPost);
		
		tx.commit();
	}
	
	@Override
	public List<Post> selectAllPosts() {
		Session ses = HibernateUtil.getSession();
		
		List<Post> postList = ses.createQuery("from Post", Post.class).list();
		
		return postList;
	}

	@Override
	public Post selectById(int postId) {
		Session ses = HibernateUtil.getSession();
		
		Post post = ses.get(Post.class, postId);
		
		return post;
	}
}