package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.service.UserServiceImpl;

@CrossOrigin(origins = "http://www.support-force.org", allowCredentials = "true")
@Controller
public class UserController {

	private static UserServiceImpl userServ;

	public UserController() {

	}

	@Autowired
	public UserController(UserServiceImpl userServ) {
		this.userServ = userServ;
	}
	
	@PostMapping(value = "login", consumes = MediaType.ALL_VALUE)
	public static @ResponseBody User login(@RequestBody User loginCred, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("Controller: In the login method");
		
		String username = loginCred.getUsername();
		String password = loginCred.getPassword();
		
		if(userServ.UserLogin(username, password) == null) {
			return null;
		} else {
			User user = userServ.UserLogin(username, password);
			request.getSession().setAttribute("currentuser", user);
			return user;
		}
		
	}
	 
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

}
