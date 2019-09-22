package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.User;
import com.project.util.HibernateUtil;

public class UserDao {

	public UserDao() {
		
	}
	
	public void insert(User myUser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myUser);
		
		tx.commit();
	}
	
	public List<User> selectAllUsers() {
		Session ses = HibernateUtil.getSession();
		
		List<User> userList = ses.createQuery("from User", User.class).list();
		
		return userList;
	}
	
}
