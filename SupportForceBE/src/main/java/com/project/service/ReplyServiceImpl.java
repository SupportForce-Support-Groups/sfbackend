package com.project.service;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.dao.ReplyDao;
import com.project.dao.ReplyDaoImpl;
import com.project.model.Post;
import com.project.model.Reply;

public class ReplyServiceImpl implements ReplyService{
	
	private ReplyDao replyDao = new ReplyDaoImpl();
	private PostDao postDao = new PostDaoImpl();
	
	@Override
	public Reply creationReply(String replyBody, int postId) {
		Post post = postDao.selectById(postId);
		
		Reply reply = new Reply(replyBody, post);
		
		replyDao.insert(reply);
		
		return reply;
	}

}
