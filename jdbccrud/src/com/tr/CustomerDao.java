package com.tr;

import java.util.List;

import com.tr.model.Customer;

public interface CustomerDao {

	
	List<Customer> allCustomers() throws CustomerException;
	Customer getCustomerById(int custid) throws CustomerException;
	int aaddCustomer(Customer cutomer) throws CustomerException;
	boolean updateCustomer(Customer cutomer) throws CustomerException;
	boolean deleteCustomer(int custid) throws CustomerException;
}
