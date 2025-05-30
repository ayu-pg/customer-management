package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ŒÚ‹qî•ñ“o˜^ƒT[ƒrƒXƒNƒ‰ƒX
 * <p>
 * 
 */

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * ŒÚ‹qî•ñ“o˜^ˆ—
	 * 
	 * @param customer
	 * @return
	 */
	public CustomerEntity registerCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	/**
	 * ŒÚ‹qî•ñˆê——ƒŠƒXƒgæ“¾ˆ—
	 * 
	 * @return
	 */
	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}
}
