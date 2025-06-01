package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

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

	/**
	 * ページング処理
	 * 
	 * @param pageable
	 * @return
	 */

	public Page<CustomerEntity> getCustomersPage(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	/**
	 * 会社名の昇順：降順ソート＋ページングを処理
	 * 
	 * @param pageable
	 * @param sortOrder
	 * @return
	 */
	public Page<CustomerEntity> getCustomersPage(Pageable pageable, String sortOrder) {
		if ("desc".equalsIgnoreCase(sortOrder)) {
			return customerRepository.findAllByOrderByCompanyNameDesc(pageable);
		} else {
			return customerRepository.findAllByOrderByCompanyNameAsc(pageable);
		}
	}

}
