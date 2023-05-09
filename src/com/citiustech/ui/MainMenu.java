package com.citiustech.ui;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.citiustech.model.Booking;
import com.citiustech.model.Customer;
import com.citiustech.model.Flight;
import com.citiustech.service.BookingService;
import com.citiustech.service.CustomerService;
import com.citiustech.service.FlightService;
import com.citiustech.utility.UserData;

public class MainMenu {

	public static void mainmenu() throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=======Welcome to ctair========");
			System.out.println("press 1 for admin");
			System.out.println("press 2 for customer");
			System.out.println("press 3 to exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			if (choice == 1) {
				adminlogin();
			} else if (choice == 2) {
				customerlogin();
			} else if (choice == 3) {
				System.exit(0);
			} else {
				System.out.println("Enter a valid choice");
			}
		}
	}

	public static void adminlogin() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// InsertFlightDetails.insertFlightDetailsToDB();
		// FlightDetailsData.displayFlights();
		// FlightUpdate.updateFlight();
		// FlightDelete.deleteFlight();
		while (true) {
			System.out.println("------------------------Admin Login System--------");
			System.out.println("Please enter Your Id");
			int id = sc.nextInt();
			System.out.println("Please Enter Your Password");

			String pwd = sc.next();
			if (id == 101 && pwd.equals("admin123")) {
				adminMenu();
			} else {
				System.out.println("Invalid user");

			}
		}

	}

	public static void customerlogin() throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------------------------Customer Login System--------");
			System.out.println("press 1 to registered");
			System.out.println("press 2 to login");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if (ch <= 2) {
				if (ch == 1) {
					customerRegistration();
				} else {
					System.out.println("===========================================================");
					System.out.println("press 1 to login");
					System.out.println("press 2 to reset Password");
					int cho = sc.nextInt();
					if (cho == 1) {
						System.out.println("========================================================");
						System.out.println("Please enter Your username");
						String user = sc.next();
						System.out.println("Please Enter Your Password");
						String pwd = sc.next();
						if (CustomerService.validateUser(user, pwd)) {
							// StaticInstance.password = pwd;
							// StaticInstance.username = user;
							// CustomerMain.customerUI();
							UserData.username = user;
							CustomerMenu();

						} else {
							System.out.println("Invalid user");

						}
					} else if (cho == 2) {
						System.out.println("==============ResetPassword=====================");
						System.out.println("Please enter Your username");
						String user = sc.next();
						System.out.println("Please Enter Your email");
						String email = sc.next();
						System.out.println("Please Enter Your resetpassword");
						String resetpwd = sc.next();
						if (CustomerService.resetPassword(user, email, resetpwd)) {
							System.out.println("Password Updated Sucessfully!!!!");
							customerlogin();

						} else {
							System.out.println("Password not reset because invalid Credential");
						}

					} else {
						System.out.println("Invalid choice");

					}

				}
			} else {
				System.out.println("Invalid choice");
			}
		}
	}

	public static void customerRegistration() throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		System.out.println("======================CustomerRegistration=============================");
		System.out.println("Enter your name\n");
		String name = sc.next();
		System.out.println("Enter your username\n");
		String username = sc.next();
		if (CustomerService.checkUsernameExist(username)) {
			System.out.println("Username already Exist!!!!");
			customerRegistration();
		}
		System.out.println("Enter your password\n");
		String pwd = sc.next();
		System.out.println("Enter your email\n");
		String email = sc.next();
		System.out.println("Enter your phonenumber");
		String phone = sc.next();
		CustomerService.insertCustomer(name, username, pwd, email, phone);

	}

	public static void customerUpdation() throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		System.out.println("======================CustomerUpdation=============================");
		System.out.println("Enter your name\n");
		String name = sc.next();
		System.out.println("Enter your password\n");
		String pwd = sc.next();
		System.out.println("Enter your email\n");
		String email = sc.next();
		System.out.println("Enter your phonenumber");
		String phone = sc.next();
		CustomerService.updateCustomer(UserData.username, name, pwd, email, phone);

	}

	public static void CustomerMenu() throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// InsertCustomer.insertCustomerToDB();
		// System.out.println(CustomerUsernameData.checkUsername("yaseen1.khan"));
		// ResetPassword.resetPassword();
		// CustomerUpdate.update();
		// CustomerDelete.deleteCustomer();
		// CustomerUsernameData.displayCustomer();
		// BookTicket.bookTicket();
		while (true) {
			System.out.println("==================================================================================");
			System.out.println("----------------customer menu---------------");
			System.out.println("press 1 to Update Customer Details");
			System.out.println("press 2 to Delete Customer Account");
			System.out.println("press 3 to Book flight ");
			System.out.println("press 4 to Cancel Ticket");
			System.out.println("press 5 to BookingHistory Bookings");
			System.out.println("press 6 to logout");
			System.out.println("press 7 to exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			if (choice <= 7) {
				switch (choice) {
				case 1:
					customerUpdation();
					CustomerMenu();
					break;
				case 2:
					CustomerService.deleteCustomer(UserData.username);
					mainmenu();
					break;
				case 3:
					bookFlight();
					break;
				case 4:
					cancelBooking();
					break;
				case 5:
					// FlightDelete.deleteFlight();
					showBooking();
					break;
				case 6:
					mainmenu();
					break;
				case 7:
					System.exit(0);
					break;

				default:
					break;
				}

			} else {
				System.out.println("Invalid Choice");
			}
		}
	}
private static void cancelBooking() {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("=============================CancelBooking=================================");
	System.out.println("Enter your BookingId to cancel");
	int bookid = sc.nextInt();
	Booking b = BookingService.getBookingById(bookid);
	if(b!=null){
		Flight f = b.getFlight();
		f.setCapacity(f.getCapacity()+b.getNoofticket());
		FlightService.insertFlight(f);
		System.out.println("Your Booking Cancelled for id "+b.getBookid());
		BookingService.deleteBooking(b);
		
		
	}
	else{
		System.out.println("Invalid Booking Id");
	}
		
	}

private static void showBooking() {
		// TODO Auto-generated method stub
		List<Booking> userbookinglist = BookingService.getCustomerBooking(UserData.username);
		if(userbookinglist.isEmpty()){
			System.out.println("You have No booking");
		}
		else{
			System.out.println("======================================================");
			System.out.println("bookid | noofticket | seatno | ticketamount | ");
			System.out.println("====================================================");
			for(Booking b:userbookinglist){
				System.out.println(b.getBookid()+"            |"+b.getNoofticket()+"         |"+b.getSeatno()
				+"         |"+b.getTicketamount());
			}
		}
	}

private static void bookFlight() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("========================BookFlight=============================================");
	System.out.println("Enter the Source location");
	String source = sc.next();
	System.out.println("Enter the Destination location");
	String destination = sc.next();
	System.out.println("Enter the FlightDate in yyyy-mm-dd");
	String date = sc.next();
	List<Flight> bookflightlist = FlightService.getBookingFlight(source, destination, date);
	if(bookflightlist.isEmpty()){
		System.out.println("No fight Found for Entered Parameters!!!!!!");
		CustomerMenu();

			}
	else{
				
		System.out.println("=========================FlightDetailsTable=====================");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("name|\t\tdate|\tsource|\tdestination|\tprice|\tduration|");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		for(Flight f:bookflightlist){
			System.out.println(f.getFlightname()+"|        "+f.getDate()+"| "
					+f.getSource()+"|  "+f.getDestination()+"|    "+f.getPrice()+"|     "+f.getDuration()+"|     ");
			System.out.println("---------------------------------------------------------------------------------------");
		}
		
		System.out.println("Enter the Flightname");
		String flightname = sc.next().toUpperCase();
		System.out.println("Enter the No of Passenger");
		int nop = sc.nextInt();
		if(FlightService.validateFlightByName(flightname)){
			Flight f = FlightService.getFlightByName(flightname);
			if(f.getCapacity()>nop){
				Customer cust = CustomerService.getCustomerByUsername(UserData.username);
				Float ticketamnt = f.getPrice()*nop;
				int seatno = f.getFlightid()+cust.getCustid()+nop;
				BookingService.bookFlight(cust, f, nop, ticketamnt, seatno);
				f.setCapacity(f.getCapacity()-nop);
				FlightService.insertFlight(f);
				
			}
			else{
				System.out.println("The No of Ticket You Entered is Not Available");
			}
			
		}
		else{
			System.out.println("Invalid Flight Name");
		}

	}
	}

public static void flightRegistration(){
	Scanner sc = new Scanner(System.in);
	System.out.println("=======================InsertFlight========================");
	System.out.println("Enter the Flightname");
	String flightname = sc.next().toUpperCase();
	System.out.println("Enter the FlightDate in yyyy-mm-dd");
	String date = sc.next();
	//Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	//System.out.println(d.getDate());
	System.out.println("Enter the Source location");
	String source = sc.next().toLowerCase();
	System.out.println("Enter the destination location");
	String destination = sc.next().toLowerCase();
	System.out.println("Enter the flight price");
	Float price = sc.nextFloat();
	System.out.println("Enter the flight duration");
	Float duration = sc.nextFloat();
	System.out.println("Enter the flight Capacity");
	int cap = sc.nextInt();
	FlightService.insertFlight(flightname, date, source, destination, price, duration, cap);
}
public static void flightUpdation() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
	Scanner sc = new Scanner(System.in);
	System.out.println("=======================UpdateFlight========================");
	System.out.println("Enter the FlightId to Update");
	int id = sc.nextInt();
	if(FlightService.validateFlightById(id)){
		String flightname = FlightService.getFlightById(id).getFlightname();
		System.out.println("Enter the FlightDatein yyyy-mm-dd");
		String date = sc.next();
		//Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		//System.out.println(d.getDate());
		System.out.println("Enter the Source location");
		String source = sc.next().toLowerCase();
		System.out.println("Enter the destination location");
		String destination = sc.next().toLowerCase();
		System.out.println("Enter the flight price");
		Float price = sc.nextFloat();
		System.out.println("Enter the flight duration");
		Float duration = sc.nextFloat();
		System.out.println("Enter the flight Capacity");
		int cap = sc.nextInt();
		FlightService.updateFlight(flightname, date, source, destination, price, duration, cap);
		}
	else{
		System.out.println("Invalid Flight ID");
		adminMenu();
	}
	
}
	public static void adminMenu() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// InsertFlightDetails.insertFlightDetailsToDB();
		// FlightDetailsData.displayFlights();
		// FlightUpdate.updateFlight();
		// FlightDelete.deleteFlight();
		while (true) {
			System.out.println(
					"=======================================================================================================================");
			System.out.println("-----------------Admin Menu----------------------");
			System.out.println("press 1 to insert Flight details");
			System.out.println("press 2 to update Flight details");
			System.out.println("press 3 to delete Flight Details");
			System.out.println("press 4 to show Customer  Details");
			System.out.println("press 5 to print Bookings");
			System.out.println("press 6 to displayFlights");
			System.out.println("press 7 for log out");
			System.out.println("press 8 to exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			if (choice <= 8) {
				switch (choice) {
				case 1:
					flightRegistration();
					break;
				case 2:
					flightUpdation();
					break;
				case 3:
					flightDeletion();
					break;
				case 4:
					customerDetailsTable();
					break;
				case 5:
					// FlightDelete.deleteFlight();
					bookingDetailsTable();

					break;
				case 6:
					flightDetailsTable();
					break;
				case 7:
					mainmenu();
					break;
				case 8:
					System.exit(0);
					break;

				default:

					break;
				}

			} else {
				System.out.println("Invalid Choice");
			}
		}
	}

	private static void bookingDetailsTable() {
		// TODO Auto-generated method stub
		List<Booking> bookinglist = BookingService.getAllBooking();
		if(bookinglist.isEmpty()){
			System.out.println("You have No booking");
		}
		else{
			System.out.println("==================================================================");
			System.out.println("bookid | noofticket | seatno | ticketamount |  custid | flightid");
			System.out.println("==================================================================");
			for(Booking b:bookinglist){
				System.out.println(b.getBookid()+"            |"+b.getNoofticket()+"         |"+b.getSeatno()
				+"         |"+b.getTicketamount()+"     |"+b.getCustomer().getCustid()+"       |"+b.getFlight().getFlightid());
			}
		}
	}

	private static void flightDetailsTable() {
		// TODO Auto-generated method stub
		System.out.println("=========================FlightDetailsTable=====================");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("id|\tname|\t\tdate|\tsource|\tdestination|\tprice|\tduration|\tcapacity|");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		for(Flight f:FlightService.getAllflight()){
			System.out.println(f.getFlightid()+"|       "+f.getFlightname()+"|        "+f.getDate()+"| "
					+f.getSource()+"|  "+f.getDestination()+"|    "+f.getPrice()+"|     "+f.getDuration()+"|     "+f.getCapacity());
			System.out.println("---------------------------------------------------------------------------------------");
		}
	}

	private static void customerDetailsTable() {
		// TODO Auto-generated method stub
		System.out.println("=========================CustomerDetailsTable=====================");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("cust_id|\tcust_name|\tusername|\tpasssword|\temail|\t\tphone|");
		System.out.println("---------------------------------------------------------------------------------------");
		for(Customer c:CustomerService.getAllCustomer()){
			System.out.println(c.getCustid()+"|        "+c.getName()+"|         "+c.getUsername()+"|      "+c.getPassword()+"|         "+c.getEmail()+"|         "+c.getPhone());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	private static void flightDeletion() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================FlightDeletion======================");
		System.out.println("Enter the FlightId to Delete a Flight");
		int id = sc.nextInt();
		if(FlightService.validateFlightById(id)){
			FlightService.deleteFlight(id);
			System.out.println("Flight Deleted Sucesfully!!!");
			
		}
		else{
			System.out.println("Invalid FlightId");
			adminMenu();
		}
	}
}
