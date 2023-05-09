package com.citiustech.dao;

import java.util.List;

import org.hibernate.Session;

import com.citiustech.model.Flight;
import com.citiustech.utility.HibernateUtility;

public class FlightDao {
	
	public static void insert(Flight f){
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.saveOrUpdate(f);
		t.commit();
	}
	public static Flight getFlightById(int id){
		return HibernateUtility.getSession().get(Flight.class, id);
	}
	public static List<Flight> getAllFlight(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select f from Flight f").getResultList();
		
	}
	public static List<Flight> getAllFlightSource(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select f.source from Flight f").getResultList();
		
	}
	public static List<Flight> getAllFlightdestination(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select f.destination from Flight f").getResultList();
		
	}
	public static List<Flight> getAllFlightdate(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select f.date from Flight f").getResultList();
		
	}
	
	public static Flight getFlightByFlightName(String fname){
		Flight fly = null;
		List<Flight> flightlist = getAllFlight();
		for(Flight f:flightlist){
			if(f.getFlightname().equals(fname)){
				fly = f;
			}
		}
		return fly;
	}
	
	public static void deleteFlight(Flight f){
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.delete(f);
		t.commit();
		//HibernateUtility.getSession().delete(f);
	}
	
	
}
