package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Addiction;
import com.project.model.SupportGroup;
import com.project.util.HibernateUtil;

public class AddictionDaoImpl implements AddictionDao{
	
	@Override
	public void insert(Addiction myAddiction) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myAddiction);
		
		tx.commit();
	}
	
	@Override
	public List<Addiction> selectAllAddictions() {
		Session ses = HibernateUtil.getSession();
		
		List<Addiction> addictionList = ses.createQuery("from Addiction", Addiction.class).list();
		
		return addictionList;
	}
	
	@Override
	public Addiction selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Addiction addiction = ses.get(Addiction.class, id);
		
		return addiction;
	}

}
