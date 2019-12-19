package com.ncl;

public class Sign_Up_Info {
	String fname;
	String lname;
	
	String emailaddress;
	String password;
	public Sign_Up_Info(String n, String n2,String a, String pn) {
	fname = n;
	lname=n2;
	emailaddress = a;
	password = pn;
	}
	public String toString( ){
	return "fname: " + fname + " eAddress: " + emailaddress +
	" password: " + password+" lname"+lname;
	}

}

