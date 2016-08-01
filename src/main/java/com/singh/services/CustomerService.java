
package com.singh.services;

import com.singh.beans.Customer;
import com.singh.mappers.CustomerMapper;
import com.singh.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;

public class CustomerService {
	
	
	public Customer selectCustomerById(Integer id){
		Customer customer = null;
		try {
			SqlSession session = MyBatis.getSqlSessionFactory().openSession();
			CustomerMapper custMapper = session.getMapper(CustomerMapper.class); 
			System.out.println("custMapper : " + custMapper);
			//String email = custMapper.selectCustomerById(id);
			//System.out.println("email : " + email);
			customer = custMapper.selectCustomerById(id);
			System.out.println("customer : " + customer);
			session.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public Customer insertCustomer(Customer customer){
		try {
			SqlSession session = MyBatis.getSqlSessionFactory().openSession();
			CustomerMapper custMapper = session.getMapper(CustomerMapper.class); 
			System.out.println("custMapper : " + custMapper);
			custMapper.insertCustomer(customer);
			System.out.println("customer : " + customer);
			session.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	
}
