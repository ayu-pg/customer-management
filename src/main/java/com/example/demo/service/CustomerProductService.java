package com.example.demo.service;

import com.example.demo.entity.CustomerProductEntity;
import com.example.demo.repository.CustomerProductRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

/**
 * 顧客商品情報サービスクラス
 * <p>
 * 
 */

@Service
public class CustomerProductService {

	@Autowired
	private CustomerProductRepository customersProductRepository;

	/**
	 * 顧客商品情報登録処理
	 * 
	 * @param customer
	 * @return
	 */
	public CustomerProductEntity registerProduct(CustomerProductEntity product) {
		return customersProductRepository.save(product);
	}

	/**
	 * 顧客商品情報一覧リスト取得処理
	 * 
	 * @return
	 */

	/*
	 * public List<CustomerProductEntity> getAllProduct() { return
	 * customersProductRepository.findAll(); }
	 */

	/**
	 * 顧客情報一覧リストソート順＋ページング処理
	 * 
	 * @param pageable
	 * @param sortOrder
	 * @return
	 */
	public Page<CustomerProductEntity> getProductPage(Pageable pageable, String sortOrder) {
		// ソート順の設定
		Sort sort = "desc".equalsIgnoreCase(sortOrder) ? Sort.by(Sort.Direction.DESC, "customerEntity.companyName")
				: Sort.by(Sort.Direction.ASC, "customerEntity.companyName");

		// 既存のページ情報にソート順を追加したPageableを作成
		Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		return customersProductRepository.findAll(sortedPageable);
	}

	/**
	 * 会社名検索処理（部分一致）
	 *
	 * @param keyword   検索キーワード（会社名）
	 * @param pageable  ページ情報
	 * @param sortOrder ソート順（asc/desc）
	 * @return 検索結果のページ
	 */
	public Page<CustomerProductEntity> searchProductByCompanyName(String keyword, Pageable pageable, String sortOrder) {
		if ("desc".equalsIgnoreCase(sortOrder)) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by("customerEntity.companyName").descending());
		} else {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
					Sort.by("customerEntity.companyName").ascending());
		}

		return customersProductRepository.findByCustomerEntityCompanyNameContaining(keyword, pageable);
	}

	/**
	 * 顧客商品一覧削除処理
	 * 
	 * @param id
	 */
	public void deleteCustomerById(Long id) {
		customersProductRepository.deleteById(id);
	}

	/**
	 * 顧客商品一覧編集処理
	 * 
	 * @param id
	 * @return
	 */
	public Optional<CustomerProductEntity> findById(Long id) {
		return customersProductRepository.findById(id);
	}

}
