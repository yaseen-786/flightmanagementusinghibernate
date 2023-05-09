package com.citiustech.service;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.citiustech.dao.BookingDao;
import com.citiustech.dao.CustomerDao;
import com.citiustech.model.Booking;
import com.citiustech.model.Customer;

public class CustomerService {
	
	public static boolean validateUser(String username, String Password) {

		boolean flag = false;
		List<String> userlist = CustomerDao.getAllUsername();
		List<String> passwordlist = CustomerDao.getAllPassword();
		if (userlist.contains(username) && passwordlist.contains(Password)) {
			System.out.println("valid user");
			flag = true;
		}
		return flag;

	}
	public static boolean checkUsernameExist(String username) {

		boolean flag = false;
		List<String> userlist = CustomerDao.getAllUsername();
		//List<String> passwordlist = CustomerDao.getAllPassword();
		if (userlist.contains(username)) {
			//System.out.println("");
			flag = true;
		}
		return flag;

	}
	public static boolean resetPassword(String username, String email,String resetPassword) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {

		boolean flag = false;
		List<String> userlist = CustomerDao.getAllUsername();
		List<String> emaillist = CustomerDao.getAllEmail();
		if(userlist.contains(username)&& emaillist.contains(email)){
			Customer cust = CustomerDao.getCustomerByUsername(username);
			cust.setPassword(resetPassword);
			CustomerDao.insertCustomer(cust);
			flag = true;
		}
		
				return flag;

	}
	public static void insertCustomer(String name,String username,String password,String email,String phone) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		Customer cust =  new Customer( name, username, password, email, phone);
		//System.out.println(cust);
		CustomerDao.insertCustomer(cust);
	}
	public static void deleteCustomer(String username){
		//Customer cust =  new Customer( name, username, password, email, phone);
		//System.out.println(cust);
		List<Booking> userbookingtodleted = BookingDao.getBookingByUsername(username);
		for(Booking b:userbookingtodleted){
			BookingService.deleteBooking(b);
		}
		CustomerDao.deleteUser(CustomerDao.getCustomerByUsername(username));
	}
	public static void updateCustomer(String username, String name, String pwd, String email, String phone) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
		Customer cust = CustomerDao.getCustomerByUsername(username);
		cust.setName(name);
		cust.setPassword(pwd);
		cust.setEmail(email);
		cust.setPhone(phone);
		CustomerDao.insertCustomer(cust);
		System.out.println("Customer Details Updated Sucessfully");
		
	}
	public static List<Customer> getAllCustomer(){
		return CustomerDao.getAllCustomer();
	}
	public static Customer getCustomerByUsername(String username){
		return CustomerDao.getCustomerByUsername(username);
	}
}
