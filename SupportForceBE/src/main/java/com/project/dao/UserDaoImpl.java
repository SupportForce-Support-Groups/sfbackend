package com.project.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Reply;
import com.project.model.SupportGroup;
import com.project.model.User;

@Transactional
//@EnableTransactionManagement(proxyTargetClass = true)
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	private SessionFactory sesFact;

	public UserDaoImpl() {
		
	}

	@Autowired
	public UserDaoImpl(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	@Override
	public void insert(User myUser) {
		
		sesFact.getCurrentSession().save(myUser);
		/*
		 * Session ses = HibernateUtil.getSession(); Transaction tx =
		 * ses.beginTransaction();
		 * 
		 * ses.save(myUser);
		 * 
		 * tx.commit();
		 */
	}
	
	@Override
	public List<User> selectAllUsers() {
		
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
		
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * List<User> userList = ses.createQuery("from User", User.class).list();
		 * 
		 * return userList;
		 */
	}
	
	@Override
	public User selectById(int userId) {
		
		return sesFact.getCurrentSession().get(User.class, userId);
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * User user = ses.get(User.class, userId);
		 * 
		 * return user;
		 */
	}
	
	/*
	 * public List<SupportGroup> selectSupportGroups(int userId) { Session ses =
	 * HibernateUtil.getSession();
	 * 
	 * User user = selectById(userId);
	 * 
	 * List<SupportGroup> supportGroups = ses.get(User.class, supportGroups); }
	 */
}
