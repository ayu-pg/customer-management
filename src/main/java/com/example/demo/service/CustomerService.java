package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

	/**
	 * 会社名検索処理（部分一致）
	 * 
	 * @param keyword
	 * @param pageable
	 * @param sortOrder
	 * @return
	 */
	public Page<CustomerEntity> searchCustomersByCompanyName(String keyword, Pageable pageable, String sortOrder) {
		if ("desc".equalsIgnoreCase(sortOrder)) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by("companyName").descending());
		} else {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by("companyName").ascending());
		}

		return customerRepository.findByCompanyNameContaining(keyword, pageable);
	}

	/**
	 * 顧客一覧削除処理
	 * 
	 * @param id
	 */
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	
	/**
	 *  顧客一覧編集遷移処理
	 * @param id
	 * @return
	 */
	public Optional<CustomerEntity> findById(Long id) {
	    return customerRepository.findById(id);
	}

}
