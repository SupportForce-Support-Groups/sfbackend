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
	
	}
	
	@Override
	public List<User> selectAllUsers() {
		
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
		
	}
	
	@Override
	public User selectById(int userId) {
		
		return sesFact.getCurrentSession().get(User.class, userId);
		
	}
	
}
