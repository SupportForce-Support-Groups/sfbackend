package com.project.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	// This method creates a post URI for creating a new Post within a Support Group.
	// This method will call the creationPost() method in the PostServiceImpl class.
	// Will create a post from the information passed in from the angular portion, supportGroupId.
	@PostMapping(value = "createPost{sgId}/{userId}")
	public @ResponseBody Object creationOfPost(@RequestBody Object post, @PathVariable("sgId") String supportGroupId,
			@PathVariable("userId") String userId) {

		System.out.println("In the creationOfPost() method.");
		System.out.println(post);

		LinkedHashMap<String, String> postObject = (LinkedHashMap<String, String>) post;

		String postBody = postObject.get("postBody");
		System.out.println(postBody);

		return postServ.creationPost(postBody, Integer.parseInt(supportGroupId), Integer.parseInt(userId));
	}

	// This method creates a get URI for getting a specific post by a post id.
	// This method will call the specificPost() method in the PostServiceImpl class.
	// Will get a specific post by postId from the database.
	@GetMapping(value = "getSpecificPost{postId}")
	public @ResponseBody Object getSpecficPost(@PathVariable("postId") String postId) {
		System.out.println("In the getSpecificPost() method.");

		return postServ.specificPost(Integer.parseInt(postId));
	}

	// This method create a get URI for getting all the posts pertaining to a specific support group.
	// This method will call the listOfPostForSupportGroup() method in the PostServiceImpl class.
	// Will retrieve all of the post associated to a support group by support group id.
	@GetMapping(value = "getAllPost{sgId}")
	public @ResponseBody Object getAllPost(@PathVariable("sgId") String supportId) {
		System.out.println("In the getAllPost() method");

		return postServ.listOfPostForSupportGroup(Integer.parseInt(supportId));

	}

}