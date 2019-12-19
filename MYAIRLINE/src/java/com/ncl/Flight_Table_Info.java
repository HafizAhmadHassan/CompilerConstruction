package com.ncl;

public class Flight_Table_Info {

	String rtime;
	String price;
	String dtime;
	String seats;
	
	public Flight_Table_Info(String n, String n2,String a, String pn) {
	rtime = n;
	price=n2;
	dtime = a;
	seats = pn;
	}


	public String getRtime() {
	return rtime;
	}

	public String getDtime() {
	return dtime;
	}

	public String getSeats() {
	return seats;
	}
	public String getPrice() {
		return price;
		}
		
}
