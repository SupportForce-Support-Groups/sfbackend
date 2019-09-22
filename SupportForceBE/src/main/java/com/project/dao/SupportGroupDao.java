package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.SupportGroup;
import com.project.util.HibernateUtil;

public class SupportGroupDao {
	
	public void insert(SupportGroup mySupportGroup) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(mySupportGroup);
		
		tx.commit();
	}
	
	public List<SupportGroup> selectAllReplies() {
		Session ses = HibernateUtil.getSession();
		
		List<SupportGroup> supportGroupList = ses.createQuery("from SupportGroup", SupportGroup.class).list();
		
		return supportGroupList;
	}


}
