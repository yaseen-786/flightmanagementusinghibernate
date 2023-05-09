package com.citiustech.service;

import java.util.List;

import com.citiustech.dao.BookingDao;
import com.citiustech.model.Booking;
import com.citiustech.model.Customer;
import com.citiustech.model.Flight;

public class BookingService {

	public static void bookFlight(Customer cust,Flight f,int noofpassenger,float ticketamnt,int seatno){
		Booking b = new Booking( cust, f, noofpassenger, ticketamnt, seatno);
		BookingDao.insert(b);
	}
	public static List<Booking> getCustomerBooking(String username){
		return BookingDao.getBookingByUsername(username);
	}
	public static List<Booking> getFlightBooking(String flightname){
		return BookingDao.getBookingByFlightName(flightname);
	}
	public static List<Booking> getAllBooking(){
		return BookingDao.getAllBooking();
	}
	public static Booking getBookingById(int id){
		return BookingDao.getBookingById(id);
	}
	public static void deleteBooking(Booking b) {
		// TODO Auto-generated method stub
		BookingDao.deleteBooking(b);
		
	}

}
