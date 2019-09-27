package com.project.dao;

import java.util.List;

import com.project.model.User;

public interface UserDao {
	
	public void insert(User myUser);
	
	public List<User> selectAllUsers();
	
	public User selectById(int userId);

}
