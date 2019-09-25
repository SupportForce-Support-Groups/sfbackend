package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.SupportGroup;
import com.project.model.User;
import com.project.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {
		
	}
	
	@Override
	public void insert(User myUser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myUser);
		
		tx.commit();
	}
	
	@Override
	public List<User> selectAllUsers() {
		Session ses = HibernateUtil.getSession();
		
		List<User> userList = ses.createQuery("from User", User.class).list();
		
		return userList;
	}
	
	@Override
	public User selectById(int userId) {
		Session ses = HibernateUtil.getSession();
		
		User user = ses.get(User.class, userId);
		
		return user;
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
