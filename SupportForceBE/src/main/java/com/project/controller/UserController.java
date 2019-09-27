package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.service.UserServiceImpl;

@CrossOrigin("*")
@Controller
public class UserController {

	private static UserServiceImpl userServ;

	public UserController() {

	}

	@Autowired
	public UserController(UserServiceImpl userServ) {
		this.userServ = userServ;
	}
	
	@PostMapping(value = "login")
	public static @ResponseBody User login(HttpServletRequest request) {
		System.out.println("Controller: In the login method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userServ.UserLogin(username, password);
		
		if(user == null) {
			return null;
		} else {
			request.getSession().setAttribute("loggeduser", user);
			return user;
		}
		
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
	public @ResponseBody Object register(@RequestBody User json) {
		System.out.println("Controller: In the register method.");
		
		System.out.println(json);
		
		User user = new User();
		
		user.setUsername(json.getUsername());
		user.setPassword(json.getPassword());
		user.setEmail(json.getEmail());
		
		return userServ.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
	}

	/*
	 * @PostMapping(value="register") public @ResponseBody User
	 * register(@RequestBody String username, @RequestBody String
	 * password, @RequestBody String email) {
	 * 
	 * System.out.println(username); System.out.println(password);
	 * System.out.println(email);
	 * 
	 * return userServ.registerUser(username, password, email);
	 * 
	 * }
	 */

}
