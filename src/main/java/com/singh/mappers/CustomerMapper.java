
package com.singh.mappers;

import com.singh.beans.Customer;
import org.apache.ibatis.annotations.Select;

public interface CustomerMapper {
	
	Customer selectCustomerById(Integer id);
	void insertCustomer (Customer customer);
	
}
