package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Post;
import com.project.model.Reply;
import com.project.model.SupportGroup;
import com.project.util.HibernateUtil;

@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
@Repository("supportGroupDao")
public class SupportGroupDaoImpl implements SupportGroupDao {
	
	private SessionFactory sesFact;

	public SupportGroupDaoImpl() {
		
	}

	@Autowired
	public SupportGroupDaoImpl(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	@Override
	public void insert(SupportGroup mySupportGroup) {
		
		sesFact.getCurrentSession().save(mySupportGroup);
		/*
		 * Session ses = HibernateUtil.getSession(); Transaction tx =
		 * ses.beginTransaction();
		 * 
		 * ses.save(mySupportGroup);
		 * 
		 * tx.commit();
		 */
	}
	
	@Override
	public List<SupportGroup> selectAllSupportGroups() {
		
		return sesFact.getCurrentSession().createQuery("from SupportGroup", SupportGroup.class).list();
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * List<SupportGroup> supportGroupList = ses.createQuery("from SupportGroup",
		 * SupportGroup.class).list();
		 * 
		 * return supportGroupList;
		 */
	}
	
	@Override
	public SupportGroup selectById(int sgId) {
		
		return sesFact.getCurrentSession().get(SupportGroup.class, sgId);
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * SupportGroup supportgrp = ses.get(SupportGroup.class, sgId);
		 * 
		 * return supportgrp;
		 */
	}
	
	/*
	 * public SupportGroup selectByName(String sgName) { Session ses =
	 * HibernateUtil.getSession();
	 * 
	 * List<SupportGroup> supportGrpList =
	 * ses.createQuery("from SupportGroup where supportGroupName='" + sgName + "'",
	 * SupportGroup.class).list(); System.out.println(supportGrpList);
	 * 
	 * if(supportGrpList.size() == 0) { System.out.
	 * println("There are more than one support group with this name, maybe specify by id."
	 * ); return null; }
	 * 
	 * return supportGrpList.get(0); }
	 */
	
	/*
	 * public void deleteSupportGroup(int supportGroupId) { Session ses =
	 * HibernateUtil.getSession();
	 * 
	 * Query query =
	 * ses.createQuery("delete SupportGroup where supportGroupId = :supportGroupId"
	 * );
	 * 
	 * query.setParameter("supportGroupId", supportGroupId);
	 * 
	 * query.executeUpdate();
	 * 
	 * }
	 */


}
