package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Post;
import com.project.model.Reply;
import com.project.util.HibernateUtil;

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
		/*
		 * Session ses = HibernateUtil.getSession(); Transaction tx =
		 * ses.beginTransaction();
		 * 
		 * ses.save(myReply);
		 * 
		 * tx.commit();
		 */
	}

	@Override
	public List<Reply> selectAllReplies() {
		
		return sesFact.getCurrentSession().createQuery("from Reply", Reply.class).list();
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * List<Reply> replyList = ses.createQuery("from Reply", Reply.class).list();
		 * 
		 * return replyList;
		 */
	}

	@Override
	public Reply selectById(int replyId) {
		
		return sesFact.getCurrentSession().get(Reply.class, replyId);
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * Reply reply = ses.get(Reply.class, replyId);
		 * 
		 * return reply;
		 */
	}

}
