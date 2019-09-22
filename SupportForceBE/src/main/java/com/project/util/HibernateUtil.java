package com.project.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session ses;
	private static Configuration conf=
			new Configuration().configure("hibernate.cfg.xml");

	static {
		conf.setProperty("hibernate.connection.username", System.getenv("DBNAME"));
		conf.setProperty("hibernate.connection.password", System.getenv("DBPASSWORD"));
		conf.setProperty("hibernate.connection.url", System.getenv("DBENDPOINT"));
	}
	
	private static SessionFactory sf= conf.buildSessionFactory();
	
	public static Session getSession() {
		
		if(ses==null)
			ses= sf.openSession();
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
		sf.close();
	}
}
