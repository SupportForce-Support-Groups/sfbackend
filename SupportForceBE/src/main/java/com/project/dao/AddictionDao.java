package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Addiction;
import com.project.util.HibernateUtil;

public class AddictionDao {
	
	public void insert(Addiction myAddiction) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myAddiction);
		
		tx.commit();
	}
	
	public List<Addiction> selectAllAddictions() {
		Session ses = HibernateUtil.getSession();
		
		List<Addiction> addictionList = ses.createQuery("from Addiction", Addiction.class).list();
		
		return addictionList;
	}

}
