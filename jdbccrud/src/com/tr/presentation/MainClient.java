package com.tr.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tr.CustomerDao;
import com.tr.CustomerDaoimpl;
import com.tr.CustomerException;
import com.tr.model.Customer;

public class MainClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomerDao dao = new CustomerDaoimpl();
		System.out.println("1.AllCustomers\n2.GetByid\n3.AddCustomer\n4.updateCustomer\n5.DeleteCustomer");
		int option = scanner.nextInt();
		switch (option) {
		case 1: {
			try {
				List<Customer> list = dao.allCustomers();
				for (Customer customer : list) {
					System.out.println(customer);

				}
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

			break;

		case 2: {
			try {
				System.out.println("Enter customer id to view");
				int custid = scanner.nextInt();
				Customer customer = dao.getCustomerById(custid);

				System.out.println(customer);

			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

			break;

			
		case 3: {
			try {
				System.out.println("Enter customer name to Add");
				
				String name=scanner.next();
				System.out.println("Enter dob dd-MM-yyyy");
				String date=scanner.next();
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
				Date dob=sf.parse(date);
				Customer customer=new Customer();
				customer.setName(name);
				customer.setDob(dob);
				int row=dao.aaddCustomer(customer);
				if(row>0)
				System.out.println("customer add successfully");
				else
					System.out.println("not added");

			} catch (CustomerException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			break;
		case 4: {
			try {
				System.out.println("Enter custid to update");
				int custid=scanner.nextInt();
				System.out.println("Enter customer name to update");
				String name=scanner.next();
				System.out.println("Enter dob dd-MM-yyyy");
				String date=scanner.next();
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
				Date dob=sf.parse(date);
				Customer customer=new Customer();
				customer.setCustid(custid);
				customer.setName(name);
				customer.setDob(dob);
				boolean status=dao.updateCustomer(customer);
				if(status)
				System.out.println("customer updated successfully");
				else
					System.out.println("not updated");

			} catch (CustomerException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

			break;
		case 5: {
			try {
				System.out.println("Enter custid to update");
				int custid=scanner.nextInt();
				
				boolean status=dao.deleteCustomer(custid);
				if(status)
				System.out.println("customer deleted successfully");
				else
					System.out.println("not deleted");

			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

			break;
		default:
			System.out.println("Enter option 1  to 5 only");
			break;
		}

	}

}
