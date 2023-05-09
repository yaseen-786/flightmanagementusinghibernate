package com.citiustech.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.citiustech.model.Booking;
import com.citiustech.model.Flight;
import com.citiustech.utility.HibernateUtility;

public class BookingDao {

	public static void insert(Booking b){
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.save(b);
		t.commit();
	}
	public static List<Booking> getAllBooking(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("select b from Booking b").getResultList();
		
	}

	public static List<Booking> getBookingByUsername(String Username){
		List<Booking> userbooklist = new ArrayList<>();
		for(Booking b:getAllBooking()){
			if(b.getCustomer().getUsername().equals(Username)){
				userbooklist.add(b);
			}
		}
		return userbooklist;
	}
	public static List<Booking> getBookingByFlightName(String flightnamename){
		List<Booking> flightbooklist = new ArrayList<>();
		for(Booking b:getAllBooking()){
			if(b.getFlight().getFlightname().equals(flightnamename)){
				flightbooklist.add(b);
			}
		}
		return flightbooklist;
	}
	public static Booking getBookingById(int id){
		return HibernateUtility.getSession().get(Booking.class, id);
	}
	public static void deleteBooking(Booking b) {
		// TODO Auto-generated method stub
		Session s = HibernateUtility.getSession();
		org.hibernate.Transaction t =  s.beginTransaction();
		s.delete(b);
		t.commit();
				
	}
}
