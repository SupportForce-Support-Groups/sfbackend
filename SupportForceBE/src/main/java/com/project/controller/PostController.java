package com.project.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.PostServiceImpl;

@CrossOrigin("*")
@Controller
public class PostController {
	
	private PostServiceImpl postServ;

	public PostController() {

	}
	
	@Autowired
	public PostController(PostServiceImpl postServ) {
		this.postServ = postServ;
	}
	
	@PostMapping(value = "createPost{sgId}/{userId}")
	public @ResponseBody Object creationOfPost(@RequestBody Object post, @PathVariable("sgId") String supportGroupId, @PathVariable("userId") String userId) {
		
		System.out.println("In the creationOfPost() method.");
		System.out.println(post);
		
		LinkedHashMap<String,String> postObject = (LinkedHashMap<String,String>) post;
		
		String postBody = postObject.get("postBody");
		System.out.println(postBody);
		
		return postServ.creationPost(postBody, Integer.parseInt(supportGroupId), Integer.parseInt(userId));
	}
	
}