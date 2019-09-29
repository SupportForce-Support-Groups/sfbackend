package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.service.PostServiceImpl;

@CrossOrigin("*")
@Controller
public class PostController {
	
	private static PostServiceImpl postServ;

	public PostController() {

	}
	
	@Autowired
	public PostController(PostServiceImpl postServ) {
		this.postServ = postServ;
	}
	
	
}