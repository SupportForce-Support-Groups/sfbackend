package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.dao.ReplyDao;
import com.project.dao.ReplyDaoImpl;
import com.project.model.Post;
import com.project.model.Reply;

@Transactional
@Service("replyServ")
public class ReplyServiceImpl implements ReplyService{
	
	private ReplyDao replyDao = new ReplyDaoImpl();
	private PostDao postDao = new PostDaoImpl();
	
	public ReplyServiceImpl() {
		
	}
	
	//@Autowired
	public ReplyServiceImpl(ReplyDaoImpl replyDao) {
		this.replyDao = replyDao;
	}
	
	@Autowired
	public ReplyServiceImpl(ReplyDaoImpl replyDao, PostDaoImpl postDao) {
		this.replyDao = replyDao;
		this.postDao = postDao;
	}
	
	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@Override
	public Reply creationReply(String replyBody, int postId) {
		Post post = postDao.selectById(postId);
		
		Reply reply = new Reply(replyBody, post);
		
		replyDao.insert(reply);
		
		return reply;
	}
	
	public List<Reply> listOfAllReplies() {
		
		return replyDao.selectAllReplies();
		
	}

}
