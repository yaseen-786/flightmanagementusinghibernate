package com.citiustech.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;

import com.citiustech.model.Customer;
import com.citiustech.utility.HibernateUtility;

public class CustomerDao {
	
	
	public static void insertCustomer(Customer cust) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.saveOrUpdate(cust);
		t.commit();
	
	}
	public static void deleteUser(Customer cust){
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.delete(cust);
		t.commit();
	}
	public static Customer getCustomerById(int id){
		Session s = HibernateUtility.getSession();
		return s.get(Customer.class, id);
	}
	public static Customer getCustomerByUsername(String username){
		//Session s = HibernateUtility.getSession();
		Customer cust = null;
		for(Customer c : getAllCustomer()){
			if(c.getUsername().equals(username)){
				cust = c;
			}
		}
		return cust;
	}
	
	public static List<Customer> getAllCustomer(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select c from Customer c").getResultList();
	}
	
	public static  List<String> getAllUsername(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select c.username from Customer c").getResultList();
	}
	
	public static  List<String> getAllPassword(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select c.password from Customer c").getResultList();
	}
	public static  List<String> getAllEmail(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select c.email from Customer c").getResultList();
	}
 
}
