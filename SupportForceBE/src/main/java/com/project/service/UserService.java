package com.project.service;

import com.project.model.User;

public interface UserService {
	
	public User UserLogin(String username, String password);
	
	public User registerUser(String username, String password, String email);

}
