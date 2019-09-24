package com.project.dao;

import java.util.List;

import javax.persistence.Query;

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
	
	public List<SupportGroup> selectAllSupportGroups() {
		Session ses = HibernateUtil.getSession();
		
		List<SupportGroup> supportGroupList = ses.createQuery("from SupportGroup", SupportGroup.class).list();
		
		return supportGroupList;
	}
	
	public SupportGroup selectById(int sgId) {
		Session ses = HibernateUtil.getSession();
		
		SupportGroup supportgrp = ses.get(SupportGroup.class, sgId);
		
		return supportgrp;
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
	
	public void deleteSupportGroup(int supportGroupId) {
		Session ses = HibernateUtil.getSession();
		
		Query query = ses.createQuery("delete SupportGroup where supportGroupId = :supportGroupId");
		
		query.setParameter("supportGroupId", supportGroupId);
		
		query.executeUpdate();
		
	}


}
