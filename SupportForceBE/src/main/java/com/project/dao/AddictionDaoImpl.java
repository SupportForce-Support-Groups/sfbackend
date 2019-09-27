package com.project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Addiction;

@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
@Repository("addictionDao")
public class AddictionDaoImpl implements AddictionDao{
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	public AddictionDaoImpl() {
		
	}
	
	@Autowired
	public AddictionDaoImpl(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}



	@Override
	public void insert(Addiction myAddiction) {
		
		sesFact.getCurrentSession().save(myAddiction);
		/*
		 * Session ses = HibernateUtil.getSession(); Transaction tx =
		 * ses.beginTransaction();
		 * 
		 * ses.save(myAddiction);
		 * 
		 * tx.commit();
		 */
	}
	
	@Override
	public List<Addiction> selectAllAddictions() {
		
		return sesFact.getCurrentSession().createQuery("from Addiction", Addiction.class).list();
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * List<Addiction> addictionList = ses.createQuery("from Addiction",
		 * Addiction.class).list();
		 * 
		 * return addictionList;
		 */
	}
	
	@Override
	public Addiction selectById(int id) {
		
		return sesFact.getCurrentSession().get(Addiction.class, id);
		/*
		 * Session ses = HibernateUtil.getSession();
		 * 
		 * Addiction addiction = ses.get(Addiction.class, id);
		 * 
		 * return addiction;
		 */
	}

}
