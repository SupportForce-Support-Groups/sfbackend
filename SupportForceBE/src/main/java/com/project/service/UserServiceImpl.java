package com.project.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;

@Transactional
@Service("userServ")
public class UserServiceImpl implements UserService {
	
	public static UserDao userDao = new UserDaoImpl();
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		UserServiceImpl.userDao = userDao;
	}

	//This method will check the login credentials that the user inputed into the fields from the Angular front end.
	//It will return the user object associated to the username and password.
	@Override
	public User UserLogin(String username, String password) {
		List<User> users = selectAllUsers();
		
		for(User user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("You're Logged in.");
				return user;
			}
		}
		System.out.println("It didn't work.");
		return null;
	}
	
	public List<User> selectAllUsers() {
		
		return userDao.selectAllUsers();
		
	}
	
	//This method will be able to register a user into the database.
	//If the user inputs a username that already exists in the database. It will return null.
	@Override
	public User registerUser(String username, String password, String email) {
		
		try {
			User newUser = new User(username, password, email);
			
			userDao.insert(newUser);
			
			return newUser;
			
		}catch(Exception e) {
			System.out.println("This username exists already. Please input a different user.");
			return null;
		}
		
		
	}

}
