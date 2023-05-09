package com.citiustech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookid;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Flight flight;
	private int noofticket;
	private Float ticketamount;
	private int seatno;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking( Customer customer, Flight flight, int noofticket, Float ticketamount, int seatno) {
		super();
		this.customer = customer;
		this.flight = flight;
		this.noofticket = noofticket;
		this.ticketamount = ticketamount;
		this.seatno = seatno;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getNoofticket() {
		return noofticket;
	}
	public void setNoofticket(int noofticket) {
		this.noofticket = noofticket;
	}
	public Float getTicketamount() {
		return ticketamount;
	}
	public void setTicketamount(Float ticketamount) {
		this.ticketamount = ticketamount;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "Booking [bookid=" + bookid + ", customer=" + customer + ", flight=" + flight + ", noofticket="
				+ noofticket + ", ticketamount=" + ticketamount + ", seatno=" + seatno + "]";
	}

}
