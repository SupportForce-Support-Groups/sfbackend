package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Addiction;
import com.project.model.Post;
import com.project.util.HibernateUtil;

@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
@Repository("postDao")
public class PostDaoImpl implements PostDao {

	private SessionFactory sesFact;

	public PostDaoImpl() {
		
	}

	@Autowired
	public PostDaoImpl(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}

	@Override
	public void insert(Post myPost) {

		sesFact.getCurrentSession().save(myPost);
		/*
		 * Session ses = HibernateUtil.getSession(); Transaction tx =
		 * ses.beginTransaction();
		 * 
		 * ses.save(myPost);
		 * 
		 * tx.commit();
		 */
	}

	@Override
	public List<Post> selectAllPosts() {
		
		return sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * List<Post> postList = ses.createQuery("from Post", Post.class).list();
		 * 
		 * return postList;
		 */
	}

	@Override
	public Post selectById(int postId) {
		
		return sesFact.getCurrentSession().get(Post.class, postId);
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * Post post = ses.get(Post.class, postId);
		 * 
		 * return post;
		 */
	}
}