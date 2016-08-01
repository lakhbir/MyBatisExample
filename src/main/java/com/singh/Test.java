/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.singh;

import com.singh.beans.Customer;
import com.singh.services.CustomerService;
import java.sql.Timestamp;
import java.util.Calendar;

public class Test {
    
	 
    public static void main(String[] args) {
			try {
				
				// Just for logging
				org.apache.ibatis.logging.LogFactory.useStdOutLogging();

				// Select from Customer table
				CustomerService cs = new CustomerService();
				Customer customer = cs.selectCustomerById(10);
				System.out.println("Email : " + customer);
				
				
//				// Insert into customer table
//				Customer c = new Customer();
//				//c.setId(22);
//				c.setEmail("y13a43d4hoo.com");
//				c.setFirstName("BINNY");
//				c.setLastName("kapri");
//				Timestamp t = new Timestamp(Calendar.getInstance().getTime().getTime());
//				c.setBirthDate(t);
//				cs.insertCustomer(c);
				
				
				} 
			catch(Exception e){
				e.printStackTrace();
				}
			
    }

}