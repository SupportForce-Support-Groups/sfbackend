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

import com.project.service.ReplyServiceImpl;

@CrossOrigin("*")
@Controller
public class ReplyController {
	
	private ReplyServiceImpl replyServ;
	
	public ReplyController() {
		
	}
	
	@Autowired
	public ReplyController(ReplyServiceImpl replyServ) {
		this.replyServ = replyServ;
	}
	
	@PostMapping(value="createReply{postId}/{sgId}/{userId}")
	public @ResponseBody Object creationOfReplies(@RequestBody Object reply, @PathVariable("postId") String postId, @PathVariable("sgId") String supportGroupId, @PathVariable("userId") String userId) {
		
		System.out.println("In createReply() method.");
		System.out.println(reply);
		
		LinkedHashMap<String, String> replyObject = (LinkedHashMap<String, String>) reply;
		String replyBody = replyObject.get("replyBody");
		
		return replyServ.creationReply(replyBody, Integer.parseInt(postId), Integer.parseInt(supportGroupId), Integer.parseInt(userId));
	}
	
	@GetMapping(value="getAllReply{postId}")
	public @ResponseBody Object getAllRepliesByPostId(@PathVariable("postId") String postId) {
		
		System.out.println("In the getAllReplies() method");
		
		return replyServ.listOfAllRepliesByPostId(Integer.parseInt(postId));
	}

}
