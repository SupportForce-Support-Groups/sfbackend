package com.project.service;

import com.project.model.Post;
import com.project.model.Reply;

public interface ReplyService {
	
	public Reply creationReply(String replyBody, int postId);

}
