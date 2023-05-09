package com.citiustech.service;

import java.util.ArrayList;
import java.util.List;

import com.citiustech.dao.BookingDao;
import com.citiustech.dao.FlightDao;
import com.citiustech.model.Booking;
import com.citiustech.model.Flight;

public class FlightService {

	public static void insertFlight(String flightname, String date, String source, String destination, Float price,
			Float duration, int capacity){
		Flight f = new Flight(flightname, date, source, destination, price, duration, capacity);
		FlightDao.insert(f);
	} 
	public static void updateFlight(String flightname, String date, String source, String destination, Float price,
			Float duration, int capacity){
		Flight f = FlightDao.getFlightByFlightName(flightname);
		f.setDate(date);
		f.setSource(source);
		f.setDestination(destination);
		f.setDuration(duration);
		f.setPrice(price);
		f.setCapacity(capacity);
		FlightDao.insert(f);
	}
	public static void insertFlight(Flight f){
		FlightDao.insert(f);
	}
	
	public static boolean validateFlightById(int id){
		boolean flag = false;
		if(FlightDao.getFlightById(id)!= null){
			flag = true;
		}
		return flag;
	}
	public static Flight getFlightByName(String flightname){
		return FlightDao.getFlightByFlightName(flightname);
	}
	public static boolean validateFlightByName(String flightname){
		boolean flag = false;
		if(getFlightByName(flightname)!=null){
			flag = true;
		}
		return flag;
	}
	
	public static Flight getFlightById(int id){
		return FlightDao.getFlightById(id);
	}
	
	public static void deleteFlight(int id){
		List<Booking> flightbookingdelete = BookingDao.getBookingByFlightName(FlightDao.getFlightById(id).getFlightname());
		for(Booking b:flightbookingdelete){
			BookingService.deleteBooking(b);
		}
		FlightDao.deleteFlight(FlightDao.getFlightById(id));
		
	}
	public static List<Flight> getAllflight(){
		return FlightDao.getAllFlight();
	}
	public static List<Flight> getBookingFlight(String source,String destination,String date){
		List<Flight> flightavail = new ArrayList<>() ;
		for(Flight f:getAllflight()){
			if(f.getSource().equals(source)&&f.getDestination().equals(destination)&&f.getDate().equals(date)){
				flightavail.add(f);
			}
		}
		return flightavail;
	}

}
