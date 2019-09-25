package com.project.dao;

import java.util.List;

import com.project.model.Reply;

public interface ReplyDao {
	
	public void insert(Reply myReply);
	
	public List<Reply> selectAllReplies();
	
	public Reply selectById(int replyId);

}
