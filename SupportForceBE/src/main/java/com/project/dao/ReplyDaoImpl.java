package com.project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Reply;

@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {

	private SessionFactory sesFact;

	public ReplyDaoImpl() {
		
	}

	@Autowired
	public ReplyDaoImpl(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}

	@Override
	public void insert(Reply myReply) {
		
		sesFact.getCurrentSession().save(myReply);
		
	}

	@Override
	public List<Reply> selectAllReplies() {
		
		return sesFact.getCurrentSession().createQuery("from Reply", Reply.class).list();
		
	}

	@Override
	public Reply selectById(int replyId) {
		
		return sesFact.getCurrentSession().get(Reply.class, replyId);
		
	}

}
