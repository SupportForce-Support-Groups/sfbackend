package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PostDao;
import com.project.dao.PostDaoImpl;
import com.project.dao.ReplyDao;
import com.project.dao.ReplyDaoImpl;
import com.project.dao.SupportGroupDao;
import com.project.dao.SupportGroupDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.Post;
import com.project.model.Reply;
import com.project.model.SupportGroup;
import com.project.model.User;

@Transactional
@Service("replyServ")
public class ReplyServiceImpl implements ReplyService{
	
	private ReplyDao replyDao = new ReplyDaoImpl();
	private PostDao postDao = new PostDaoImpl();
	private SupportGroupDao sgDao = new SupportGroupDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	
	public ReplyServiceImpl() {
		
	}
	
	//@Autowired
	public ReplyServiceImpl(ReplyDaoImpl replyDao) {
		this.replyDao = replyDao;
	}
	
	@Autowired
	public ReplyServiceImpl(ReplyDaoImpl replyDao, PostDaoImpl postDao, SupportGroupDaoImpl sgDao, UserDaoImpl userDao) {
		this.replyDao = replyDao;
		this.postDao = postDao;
		this.sgDao = sgDao;
		this.userDao = userDao;
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
	public Reply creationReply(String replyBody, int postId, int supportGroupId, int userId) {
		Post post = postDao.selectById(postId);
		
		Reply reply = new Reply(replyBody, post);
		
		replyDao.insert(reply);
		
		post.getReplies().add(reply);
		System.out.println(post.getReplies());
		
		SupportGroup supportGroup = sgDao.selectById(supportGroupId);
		supportGroup.getReplyList().add(reply);
		
		User user = userDao.selectById(userId);
		user.getReplies().add(reply);
		
		return reply;
	}
	
	public List<Reply> listOfAllReplies() {
		
		return replyDao.selectAllReplies();
		
	}

}
