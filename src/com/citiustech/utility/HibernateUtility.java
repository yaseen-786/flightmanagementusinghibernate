package com.citiustech.utility;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	public static SessionFactory getSessionFactory(){
		return new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession(){
		return getSessionFactory().openSession();
	}
	

}
