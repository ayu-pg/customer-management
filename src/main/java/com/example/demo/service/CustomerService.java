package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

/**
 * 顧客情報サービスクラス
 * <p>
 * 
 */

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 顧客情報登録処理
	 * 
	 * @param customer
	 * @return
	 */
	public CustomerEntity registerCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	/**
	 * 顧客情報一覧リスト取得処理
	 * 
	 * @return
	 */
	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	//
	/**
	 * 会社名の昇順ソート処理
	 * 
	 * @return
	 */
	public List<CustomerEntity> getCustomersSortedByCompanyNameAsc() {
		return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "companyName"));
	}

	/**
	 * 会社名の降順ソート処理
	 * 
	 * @return
	 */
	public List<CustomerEntity> getCustomersSortedByCompanyNameDesc() {
		return customerRepository.findAll(Sort.by(Sort.Direction.DESC, "companyName"));
	}

}
