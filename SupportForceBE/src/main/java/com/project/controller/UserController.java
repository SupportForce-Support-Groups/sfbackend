package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.service.UserServiceImpl;

@CrossOrigin("*")
@Controller
public class UserController {

	private UserServiceImpl userServ;

	public UserController() {

	}

	@Autowired
	public UserController(UserServiceImpl userServ) {
		this.userServ = userServ;
	}
	
	public static String login(HttpSession session) {
		System.out.println("In the login method");
		
		session.setAttribute("currentUserName", "jyothi");
		
		return null;
		
	}
	/*
	 * @PostMapping(value="login")
	
	/*
	 * public @ResponseBody User login(@RequestBody String username, @RequestBody
	 * String password) {
	 * 
	 * return userServ.UserLogin(username, password);
	 * 
	 * }
	 */
	 


	@PostMapping(value="register")
	public @ResponseBody User register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {

		return userServ.registerUser(username, password, email);

	}

}
