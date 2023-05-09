package com.citiustech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightid;
	@Column(unique=true)
	private String flightname;
	private String date;
	private String source;
	private String destination;
	private Float price;
	private Float duration;
	private int capacity;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight( String flightname, String date, String source, String destination, Float price,
			Float duration, int capacity) {
		super();
		
		this.flightname = flightname;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.duration = duration;
		this.capacity = capacity;
	}
	public Integer getFlightid() {
		return flightid;
	}
	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname.toUpperCase();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source.toLowerCase();
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination.toLowerCase();
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightname=" + flightname + ", date=" + date + ", source=" + source
				+ ", destination=" + destination + ", price=" + price + ", duration=" + duration + ", capacity="
				+ capacity + "]";
	}
}
	
	

