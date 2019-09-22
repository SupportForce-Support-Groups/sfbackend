package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Reply;
import com.project.util.HibernateUtil;

public class ReplyDao {
	
	public void insert(Reply myReply) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myReply);
		
		tx.commit();
	}
	
	public List<Reply> selectAllReplies() {
		Session ses = HibernateUtil.getSession();
		
		List<Reply> replyList = ses.createQuery("from Reply", Reply.class).list();
		
		return replyList;
	}

}
