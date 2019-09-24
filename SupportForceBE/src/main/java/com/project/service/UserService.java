package com.project.service;

import java.util.List;

import com.project.dao.UserDao;
import com.project.model.User;

public class UserService {
	
	public static UserDao userDao = new UserDao();
	
	public static void main(String[] args) {
		UserLogin("jyothi", "password");
	}
	
	public static User UserLogin(String username, String password) {
		List<User> users = userDao.selectAllUsers();
		
		System.out.println("This should be a list of users: " + users);
		
		System.out.println("This is your username " + username);
		System.out.println("This is your password " + password);
		
		for(User user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("This is your username " + username);
				System.out.println("This is your password " + password);
				System.out.println("You're Logged in.");
				return user;
			}
		}
		System.out.println("It didn't work.");
		return null;
	}

}
