package com.project.service;

import java.util.List;

import com.project.model.Post;
import com.project.model.Reply;

public interface ReplyService {
	
	public Reply creationReply(String replyBody, int postId, int supportGroupId, int userId);
	
	public List<Reply> listOfAllRepliesByPostId(int postId);
	
	

}
