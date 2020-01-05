package com.tr.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

	
	private int custid;
	private String name;
	private Date dob;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int custid, String name, Date dob) {
		super();
		this.custid = custid;
		this.name = name;
		this.dob = dob;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
		
		return " \n custid=" + custid + ", name=" + name + ", dob=" + sf.format(dob);
	}
	
	
}
